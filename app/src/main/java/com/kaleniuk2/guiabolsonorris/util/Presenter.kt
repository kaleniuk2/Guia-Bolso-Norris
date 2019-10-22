package com.kaleniuk2.guiabolsonorris.util

interface Presenter<T> {
    fun onSuccess(response: T)
    fun onFailure()
    fun onComplete()
}