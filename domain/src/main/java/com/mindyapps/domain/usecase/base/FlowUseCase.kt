package com.mindyapps.domain.usecase.base

import kotlinx.coroutines.flow.Flow
import com.mindyapps.domain.core.Result

interface FlowUseCase<out T, in Params> {

    operator fun invoke(params: Params): Flow<Result<T>>

}