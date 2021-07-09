package com.mindyapps.remote.source

import com.mindyapps.remote.utils.executeRemoteRequest
import com.mindyapps.data.source.NewsRemoteDataSource
import com.mindyapps.domain.entity.NewsEntity
import com.mindyapps.remote.api.NewsApiService
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsRemoteDataSource {

    override suspend fun getNews(): com.mindyapps.domain.core.Result<NewsEntity> =
        executeRemoteRequest { newsApiService.getEverything("tesla") }

}
