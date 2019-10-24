package com.kaleniuk2.guiabolsonorris.feature.category.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.kaleniuk2.guiabolsonorris.R
import com.kaleniuk2.guiabolsonorris.core.BaseActivity
import com.kaleniuk2.guiabolsonorris.feature.detail.ui.DetailActivity
import com.kaleniuk2.guiabolsonorris.util.ToastHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class CategoryActivity : BaseActivity(), CategoryView {

    lateinit var presenter: CategoryContract
    lateinit var categories: List<String>
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = TITLE
        presenter.getCategories()
        detail_edit_text_search.addTextChangedListener(textWatcher)
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            //Nao faz nada
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //Nao faz nada
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (::categories.isInitialized || s.toString() != "") {
                val result = arrayListOf<String>()
                for (categorie in categories) {
                    if (categorie.contains(s.toString()))
                        result.add(categorie)
                }
                updateAdapter(result)
            } else {
                updateAdapter(categories)
            }
        }

    }

    private fun updateAdapter(list: List<String>) {
        adapter.categories = list
        adapter.notifyDataSetChanged()
    }

    override fun onInject() {
        this.presenter = CategoryPresenter(this)
    }

    override fun getLayout() = R.layout.activity_main

    override fun onSuccessCategories(categories: List<String>) {
        this.categories = categories
        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter = CategoryAdapter(this.categories) {
            startActivity(DetailActivity.onNewIntent(this, it))
        }
        rv_category.adapter = adapter
        rv_category.layoutManager = LinearLayoutManager(this)
        rv_category.setHasFixedSize(true)
    }

    override fun onErrorCategories(error: String) {
        ToastHelper.show(this, "Erro ao obter lista")
    }

    override fun onComplete() {
        hideProgressBar()
    }

    override fun showProgressBar() {
        progress_category.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress_category.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        this.presenter.view = null
    }

    companion object {
        private const val TITLE = "Categorias"
        fun onNewIntent(context: Context): Intent {
            return Intent(context, CategoryActivity::class.java)
        }
    }
}
