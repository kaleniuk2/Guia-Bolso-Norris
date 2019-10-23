package com.kaleniuk2.guiabolsonorris.feature.category.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.kaleniuk2.guiabolsonorris.R
import com.kaleniuk2.guiabolsonorris.core.BaseActivity
import com.kaleniuk2.guiabolsonorris.feature.detail.ui.DetailActivity
import com.kaleniuk2.guiabolsonorris.util.ToastHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class CategoryActivity : BaseActivity(), CategoryView {

    lateinit var presenter: CategoryContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = TITLE
        presenter.getCategories()
    }

    override fun onInject() {
        this.presenter = CategoryPresenter(this)
    }

    override fun getLayout() = R.layout.activity_main

    override fun onSuccessCategories(categories: List<String>) {
        rv_category.adapter = CategoryAdapter(categories){
            startActivity(DetailActivity.onNewIntent(this, it))
        }
        rv_category.layoutManager = GridLayoutManager(this, 2)
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
