package com.kaleniuk2.guiabolsonorris.feature.detail.datasource

import com.kaleniuk2.guiabolsonorris.core.RetrofitFactory
import com.kaleniuk2.guiabolsonorris.feature.detail.ui.DetailContract
import com.kaleniuk2.guiabolsonorris.model.Joke
import retrofit2.Call
import retrofit2.Response

class DetailRemoteDataSource : DetailDataSource {

    private val retrofit: DetailService by lazy {
        RetrofitFactory.detailService()
    }

    override fun getJoke(presenter: DetailContract, category: String) {
        retrofit.getJoke(category).enqueue(object : retrofit2.Callback<Joke> {
            override fun onFailure(call: Call<Joke>, t: Throwable) {
                presenter.onFailure(t.localizedMessage)
                presenter.onComplete()
            }

            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (!response.isSuccessful)
                    presenter.onFailure("Erro ao buscar categoria!")
                else {
                    response.body()?.let {
                        presenter.onSuccess(it)
                    }
                }
                presenter.onComplete()
            }

        })
    }


}