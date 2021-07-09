package com.mindyapps.cache.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mindyapps.cache.db.model.ArticleModel
import com.mindyapps.domain.entity.ArticleEntity

class ListConverter {

    @TypeConverter
    fun fromArticleModelList(value: List<ArticleModel>?): String {
        val gson = Gson()
        val type = object : TypeToken<List<ArticleModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toArticleModelList(value: String): List<ArticleModel> {
        val gson = Gson()
        val type = object : TypeToken<List<ArticleModel>>() {}.type
        return gson.fromJson(value, type)
    }
}