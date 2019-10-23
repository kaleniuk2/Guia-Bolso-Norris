package com.kaleniuk2.guiabolsonorris.feature.detail.ui

import android.content.Context
import android.content.Intent
import android.icu.util.LocaleData
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.kaleniuk2.guiabolsonorris.R
import com.kaleniuk2.guiabolsonorris.core.BaseActivity
import com.kaleniuk2.guiabolsonorris.model.Joke
import com.kaleniuk2.guiabolsonorris.util.DateHelper
import com.kaleniuk2.guiabolsonorris.util.ToastHelper
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*


class DetailActivity : BaseActivity(), DetailView {

    lateinit var presenter: DetailContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = TITLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val category = intent.extras?.getString(KEY_CATEGORY)


        category?.let {
            presenter.getJoke(it)
        }
    }

    override fun onInject() {
        this.presenter = DetailPresenter(this)
    }

    override fun getLayout() = R.layout.activity_detail


    override fun showProgressBar() {
        detail_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        detail_progress_bar.visibility = View.GONE
    }

    override fun onSuccessDetail(joke: Joke) {
        detail_text_view_created.text = DateHelper.convertDateEuaToBr(joke.created_at)
        detail_text_view_update.text = DateHelper.convertDateEuaToBr(joke.updated_at)
        detail_text_view_joke.text = joke.value
        detail_text_view_see_online.text = joke.url
    }

    override fun onFailureDetail(error: String) {
        ToastHelper.show(this, error)
    }

    override fun onComplete() {
        hideProgressBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.presenter.view = null
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val TITLE = "Detalhes"
        private const val KEY_CATEGORY = "category"

        fun onNewIntent(context: Context, category: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY_CATEGORY, category)

            return intent
        }
    }
}
