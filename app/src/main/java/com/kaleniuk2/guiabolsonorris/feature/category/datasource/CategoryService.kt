package com.kaleniuk2.guiabolsonorris.feature.category.datasource

import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {

    @GET("jokes/categories")
    fun getCategories(): Call<List<String>>
}