package com.mindyapps.remote.api

import com.mindyapps.domain.entity.NewsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApiService {

    @GET("everything")
    suspend fun getEverything(@Query("q") query: String): Response<NewsEntity>
}