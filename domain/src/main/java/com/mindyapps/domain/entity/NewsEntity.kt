package com.mindyapps.domain.entity

data class NewsEntity(
    val status: String?,
    val totalResults: String?,
    val articles: List<ArticleEntity>
)