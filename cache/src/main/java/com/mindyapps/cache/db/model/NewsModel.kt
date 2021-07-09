package com.mindyapps.cache.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsModel(
    @PrimaryKey (autoGenerate = true)
    val id: Int?,
    val status: String?,
    val totalResults: String?,
    val articles: List<ArticleModel>
)