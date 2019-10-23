package com.kaleniuk2.guiabolsonorris.feature.detail.datasource

import com.kaleniuk2.guiabolsonorris.feature.detail.ui.DetailContract

interface DetailDataSource {
    fun getJoke(presenter: DetailContract, category: String)
}