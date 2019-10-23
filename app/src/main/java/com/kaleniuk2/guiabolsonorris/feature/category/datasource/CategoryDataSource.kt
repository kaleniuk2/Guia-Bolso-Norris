package com.kaleniuk2.guiabolsonorris.feature.category.datasource

import com.kaleniuk2.guiabolsonorris.feature.category.ui.CategoryContract

interface CategoryDataSource {
    fun getCategories(presenter: CategoryContract)
}