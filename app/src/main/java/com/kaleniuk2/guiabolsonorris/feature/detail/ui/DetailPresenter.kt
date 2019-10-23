package com.kaleniuk2.guiabolsonorris.feature.detail.ui

import com.kaleniuk2.guiabolsonorris.feature.detail.datasource.DetailDataSource
import com.kaleniuk2.guiabolsonorris.feature.detail.datasource.DetailRemoteDataSource
import com.kaleniuk2.guiabolsonorris.model.Joke

class DetailPresenter(override var view: DetailView?) : DetailContract {

    private val dataSource: DetailDataSource by lazy {
        DetailRemoteDataSource()
    }

    override fun getJoke(category: String) {
        dataSource.getJoke(this, category)
    }

    override fun onSuccess(response: Joke) {
        view?.onSuccessDetail(response)
    }

    override fun onFailure(error: String) {
        view?.onFailureDetail(error)
    }

    override fun onComplete() {
        view?.onComplete()
    }

    override fun onDestroy() {
        this.view = null
    }
}