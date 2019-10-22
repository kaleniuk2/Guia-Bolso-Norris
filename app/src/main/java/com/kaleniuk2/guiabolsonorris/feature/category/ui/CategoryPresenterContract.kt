package com.kaleniuk2.guiabolsonorris.feature.category.ui

import com.kaleniuk2.guiabolsonorris.util.Presenter

interface CategoryPresenterContract : Presenter<List<String>> {
    var view: CategoryView
    fun getCategories()
}