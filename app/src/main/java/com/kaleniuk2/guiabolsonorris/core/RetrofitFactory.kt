package com.kaleniuk2.guiabolsonorris.core

import com.kaleniuk2.guiabolsonorris.feature.category.datasource.CategoryService
import com.kaleniuk2.guiabolsonorris.feature.detail.datasource.DetailService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun categoryService() = retrofit.create(CategoryService::class.java)
    fun detailService() = retrofit.create(DetailService::class.java)
}