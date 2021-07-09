package com.mindyapps.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mindyapps.cache.db.dao.ArticlesDao
import com.mindyapps.cache.db.dao.NewsDao
import com.mindyapps.cache.db.model.ArticleModel
import com.mindyapps.cache.db.model.NewsModel

@Database(
    entities = [NewsModel::class, ArticleModel::class],
    version = 1
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    abstract fun articlesDao(): ArticlesDao

}