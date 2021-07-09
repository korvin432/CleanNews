package com.mindyapps.domain.repository

import com.mindyapps.domain.entity.NewsEntity
import com.mindyapps.domain.core.Result

interface NewsRepository {

    suspend fun getNews(): Result<NewsEntity>
}