package com.mindyapps.data.source

import com.mindyapps.domain.core.Result
import com.mindyapps.domain.entity.NewsEntity
import com.mindyapps.domain.entity.ArticleEntity

interface NewsLocalDataSource {

    suspend fun getNews(): Result<NewsEntity>

    suspend fun saveNews(newsEntity: NewsEntity)

    suspend fun saveArticle(articleEntity: ArticleEntity)

    suspend fun getArticle(id: String): Result<ArticleEntity>

}