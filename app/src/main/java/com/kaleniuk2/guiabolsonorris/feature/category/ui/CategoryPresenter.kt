package com.kaleniuk2.guiabolsonorris.feature.category.ui

import com.kaleniuk2.guiabolsonorris.feature.category.datasource.CategoryDataSource
import com.kaleniuk2.guiabolsonorris.feature.category.datasource.CategoryRemoteDataSource

class CategoryPresenter(override var view: CategoryView?) : CategoryPresenterContract {
    override fun onDestroy() {
        view = null
    }

    private val dataSource: CategoryDataSource by lazy {
        CategoryRemoteDataSource()
    }

    override fun getCategories() {
        dataSource.getCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        view?.onSuccessCategories(response)
    }

    override fun onFailure(error: String) {
        view?.onErrorCategories(error)
    }

    override fun onComplete() {
        view?.onComplete()
    }
}