package com.mindyapps.domain.usecase

import com.mindyapps.domain.entity.NewsEntity
import com.mindyapps.domain.repository.NewsRepository
import com.mindyapps.domain.core.Result
import com.mindyapps.domain.usecase.base.SuspendUseCase
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) : SuspendUseCase<NewsEntity, Unit> {
    override suspend fun invoke(params: Unit): Result<NewsEntity> {
        return repository.getNews()
    }
}