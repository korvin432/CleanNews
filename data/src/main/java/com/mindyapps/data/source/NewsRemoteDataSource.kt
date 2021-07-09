package com.mindyapps.data.source

import com.mindyapps.domain.core.Result
import com.mindyapps.domain.entity.NewsEntity

interface NewsRemoteDataSource {

    suspend fun getNews(): Result<NewsEntity>

}