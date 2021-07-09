package com.mindyapps.domain.usecase.base

import com.mindyapps.domain.core.Result

interface SuspendUseCase<out T, in Params> {

    suspend operator fun invoke(params: Params): Result<T>

}