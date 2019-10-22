package com.kaleniuk2.guiabolsonorris.util

interface Presenter<T> {
    fun onSuccess(response: T)
    fun onFailure(error: String)
    fun onComplete()
    fun onDestroy()
}