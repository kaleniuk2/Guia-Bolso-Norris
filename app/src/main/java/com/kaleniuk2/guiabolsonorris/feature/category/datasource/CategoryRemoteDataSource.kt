package com.kaleniuk2.guiabolsonorris.feature.category.datasource

import com.kaleniuk2.guiabolsonorris.feature.category.ui.CategoryPresenter
import com.kaleniuk2.guiabolsonorris.util.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource : CategoryDataSource {

    private val categoryService: CategoryService by lazy {
        RetrofitFactory.categoryService()
    }

    override fun getCategories(presenter: CategoryPresenter) {
        categoryService.getCategories().enqueue(object : Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                presenter.onFailure(t.localizedMessage)
                presenter.onComplete()
            }

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        presenter.onSuccess(it)
                    }
                } else {
                    presenter.onFailure("Erro ao obter categorias")
                }

                presenter.onComplete()
            }
        })
    }
}