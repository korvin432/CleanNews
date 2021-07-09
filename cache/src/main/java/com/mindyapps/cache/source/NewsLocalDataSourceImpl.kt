package com.mindyapps.cache.source

import com.mindyapps.cache.db.dao.ArticlesDao
import com.mindyapps.cache.db.dao.NewsDao
import com.mindyapps.cache.db.mapper.ArticlesMapper
import com.mindyapps.cache.db.mapper.NewsMapper
import com.mindyapps.cache.utils.executeLocalRequest
import com.mindyapps.data.source.NewsLocalDataSource
import com.mindyapps.domain.core.Result
import com.mindyapps.domain.entity.ArticleEntity
import com.mindyapps.domain.entity.NewsEntity
import com.mindyapps.domain.ext.mapResult
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(
    private val newsDao: NewsDao,
    private val articlesDao: ArticlesDao,
    private val newsMapper: NewsMapper,
    private val articlesMapper: ArticlesMapper
) : NewsLocalDataSource {

    override suspend fun getNews(): Result<NewsEntity> =
        executeLocalRequest { newsDao.getNews() }
            .mapResult(newsMapper)

    override suspend fun saveNews(newsEntity: NewsEntity) =
        newsDao.insert(newsMapper.mapTo(newsEntity))

    override suspend fun saveArticle(articleEntity: ArticleEntity)  =
        articlesDao.insert(articlesMapper.mapTo(articleEntity))

    override suspend fun getArticle(id: String): Result<ArticleEntity>  =
        executeLocalRequest { articlesDao.getArticle(id) }
            .mapResult(articlesMapper)

}