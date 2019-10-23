package com.kaleniuk2.guiabolsonorris.feature.detail.ui

import com.kaleniuk2.guiabolsonorris.core.Presenter
import com.kaleniuk2.guiabolsonorris.model.Joke

interface DetailContract : Presenter<Joke> {
    var view: DetailView?
    fun getJoke(category: String)
}