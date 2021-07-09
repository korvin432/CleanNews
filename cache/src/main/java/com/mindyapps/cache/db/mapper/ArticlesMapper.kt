package com.mindyapps.cache.db.mapper

import com.mindyapps.cache.db.model.ArticleModel
import com.mindyapps.domain.core.Mapper
import com.mindyapps.domain.entity.ArticleEntity
import javax.inject.Inject

class ArticlesMapper @Inject constructor() : Mapper<ArticleModel, ArticleEntity> {

    override fun mapFrom(from: ArticleModel): ArticleEntity {
        return ArticleEntity(
            id = from.id,
            author = from.author,
            title = from.title,
            content = from.content
        )
    }

    override fun mapTo(from: ArticleEntity): ArticleModel {
        return ArticleModel(
            id = from.id,
            author = from.author,
            title = from.title,
            content = from.content
        )
    }

}