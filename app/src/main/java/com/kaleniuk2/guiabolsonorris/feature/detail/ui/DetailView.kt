package com.kaleniuk2.guiabolsonorris.feature.detail.ui

import com.kaleniuk2.guiabolsonorris.core.View
import com.kaleniuk2.guiabolsonorris.model.Joke


interface DetailView : View {
    fun onSuccessDetail(joke: Joke)
    fun onFailureDetail(error: String)
    fun onComplete()
}