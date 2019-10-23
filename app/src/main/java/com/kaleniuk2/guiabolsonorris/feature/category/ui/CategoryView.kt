package com.kaleniuk2.guiabolsonorris.feature.category.ui

import com.kaleniuk2.guiabolsonorris.core.View

interface CategoryView : View {
    fun onSuccessCategories(categories: List<String>)
    fun onErrorCategories(error: String)
    fun onComplete()
}