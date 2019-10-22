package com.kaleniuk2.guiabolsonorris.feature.category.ui

import com.kaleniuk2.guiabolsonorris.feature.category.datasource.CategoryDataSource
import com.kaleniuk2.guiabolsonorris.feature.category.datasource.CategoryRemoteDataSource
import com.kaleniuk2.guiabolsonorris.util.Presenter

class CategoryPresenter() : CategoryPresenterContract {
    private val dataSource: CategoryDataSource by lazy {
        CategoryRemoteDataSource()
    }

    override fun getCategories() {
        dataSource.getCategories(this)
    }

    override fun onSuccess(response: List<String>) {

    }

    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}