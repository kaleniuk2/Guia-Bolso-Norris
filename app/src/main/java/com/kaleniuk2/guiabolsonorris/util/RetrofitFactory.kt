package com.kaleniuk2.guiabolsonorris.util

import com.kaleniuk2.guiabolsonorris.feature.category.datasource.CategoryService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.23:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun categoryService(): CateggoryService {
        return retrofit.create(NoteService::class.java)
    }
}