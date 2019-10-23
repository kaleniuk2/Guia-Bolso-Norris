package com.kaleniuk2.guiabolsonorris.feature.detail.ui

import android.content.Context
import android.content.Intent
import android.icu.util.LocaleData
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.kaleniuk2.guiabolsonorris.R
import com.kaleniuk2.guiabolsonorris.core.BaseActivity
import com.kaleniuk2.guiabolsonorris.model.Joke
import com.kaleniuk2.guiabolsonorris.util.DateHelper
import com.kaleniuk2.guiabolsonorris.util.ToastHelper
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import java.lang.Exception


class DetailActivity : BaseActivity(), DetailView {

    lateinit var presenter: DetailContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val category = intent.extras?.getString(KEY_CATEGORY)
        supportActionBar?.title = category?.capitalize()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        category?.let {
            presenter.getJoke(it)
            fab_detail.setOnClickListener { _ ->
                presenter.getJoke(it)
            }
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
        bind(joke)
    }

    fun bind(joke: Joke) {
        detail_text_view_created.text = "Data de criação: " + DateHelper.convertDateEuaToBr(joke.created_at)
        detail_text_view_update.text = "Data de atualização: " + DateHelper.convertDateEuaToBr(joke.updated_at)
        detail_text_view_joke.text = joke.value
        detail_text_view_see_online.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(joke.url)))
        }

        Picasso.get().load(joke.icon_url).into(image_detail, object : Callback {
            override fun onSuccess() {
                progress_image.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
                progress_image.visibility = View.GONE
            }

        })
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
