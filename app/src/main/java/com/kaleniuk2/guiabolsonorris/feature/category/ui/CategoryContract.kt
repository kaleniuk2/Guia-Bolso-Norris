package com.kaleniuk2.guiabolsonorris.feature.category.ui

import com.kaleniuk2.guiabolsonorris.core.Presenter

interface CategoryContract : Presenter<List<String>> {
    var view: CategoryView?
    fun getCategories()
}