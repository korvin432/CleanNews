package com.mindyapps.cache.di

import com.mindyapps.cache.source.NewsLocalDataSourceImpl
import com.mindyapps.data.source.NewsLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun provideNewsLocalDataSource(newsLocalDataSourceImpl: NewsLocalDataSourceImpl): NewsLocalDataSource

}