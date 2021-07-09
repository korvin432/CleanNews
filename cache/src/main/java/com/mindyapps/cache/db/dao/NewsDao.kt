package com.mindyapps.cache.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.mindyapps.cache.db.model.NewsModel

@Dao
interface NewsDao: BaseDao<NewsModel> {

    @Query("SELECT * FROM news LIMIT 1")
    suspend fun getNews(): NewsModel
}