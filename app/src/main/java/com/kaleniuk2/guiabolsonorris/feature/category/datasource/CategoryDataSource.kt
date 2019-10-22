package com.kaleniuk2.guiabolsonorris.feature.category.datasource

import com.kaleniuk2.guiabolsonorris.feature.category.ui.CategoryPresenter

interface CategoryDataSource {
    fun getCategories(presenter: CategoryPresenter)
}