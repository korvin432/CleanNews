package com.mindyapps.cache.db.mapper

import com.mindyapps.cache.db.model.NewsModel
import com.mindyapps.domain.core.Mapper
import com.mindyapps.domain.entity.NewsEntity
import javax.inject.Inject

class NewsMapper @Inject constructor(
        private val articlesMapper: ArticlesMapper
) : Mapper<NewsModel, NewsEntity> {

    override fun mapFrom(from: NewsModel): NewsEntity {
        return NewsEntity(
                status = from.status,
                totalResults = from.totalResults,
                articles = from.articles.map { articlesMapper.mapFrom(it) }
        )
    }

    override fun mapTo(from: NewsEntity): NewsModel {
        return NewsModel(
                id = null,
                status = from.status,
                totalResults = from.totalResults,
                articles = from.articles.map { articlesMapper.mapTo(it) }
        )
    }

}