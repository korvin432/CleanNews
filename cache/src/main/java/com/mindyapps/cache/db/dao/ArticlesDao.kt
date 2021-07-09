package com.mindyapps.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.mindyapps.cache.db.model.ArticleModel
import com.mindyapps.cache.db.model.NewsModel

@Dao
interface ArticlesDao: BaseDao<ArticleModel> {

    @Query("SELECT * FROM article WHERE id = :id LIMIT 1")
    suspend fun getArticle(id: String?): ArticleModel
}