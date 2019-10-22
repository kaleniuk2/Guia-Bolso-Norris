package com.kaleniuk2.guiabolsonorris.feature.category.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kaleniuk2.guiabolsonorris.R
import com.kaleniuk2.guiabolsonorris.util.BaseActivity
import com.kaleniuk2.guiabolsonorris.util.ToastHelper

class CategoryActivity : BaseActivity(), CategoryView {

    lateinit var presenter: CategoryPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onInject() {
        this.presenter = CategoryPresenter()
        this.presenter.view = this
    }

    override fun getLayout() = R.layout.activity_main

    override fun onSuccessCategories(categories: List<String>) {
        Log.i("LISTAA", categories.toString())
    }

    override fun onErrorCategories(error: String) {
        ToastHelper.show(this, "Erro ao obter lista")
    }

    override fun onComplete() {
        hideProgressBar()
    }

    override fun showProgressBar() {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun onNewIntent(context: Context): Intent {
            return Intent(context, CategoryActivity::class.java)
        }
    }
}
