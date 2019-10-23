package com.kaleniuk2.guiabolsonorris.feature.detail.datasource

import com.kaleniuk2.guiabolsonorris.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailService {

    @GET("jokes/random")
    fun getJoke(@Query("category") category: String): Call<Joke>
}