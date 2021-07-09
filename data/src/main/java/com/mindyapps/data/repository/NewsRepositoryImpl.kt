package com.mindyapps.data.repository

import com.mindyapps.data.source.NewsLocalDataSource
import com.mindyapps.data.source.NewsRemoteDataSource
import com.mindyapps.domain.core.Result
import com.mindyapps.domain.di.IoDispatcher
import com.mindyapps.domain.entity.NewsEntity
import com.mindyapps.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : NewsRepository {

    override suspend fun getNews(): Result<NewsEntity> = withContext(ioDispatcher) {
        var result = newsRemoteDataSource.getNews()
        when (result) {
            is Result.Success -> launch { newsLocalDataSource.saveNews((result as Result.Success).data) }
            is Result.Error -> when (val localResult = newsLocalDataSource.getNews()) {
                is Result.Success -> result = localResult
            }
        }
        result
    }

}