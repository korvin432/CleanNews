package com.mindyapps.cache.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleModel(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val author: String?,
    val title: String?,
    val content: String?
)