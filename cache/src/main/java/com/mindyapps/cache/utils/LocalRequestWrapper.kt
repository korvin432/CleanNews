package com.mindyapps.cache.utils

import com.mindyapps.domain.core.Failure
import com.mindyapps.domain.core.Result
import com.mindyapps.domain.ext.parseLocalError
import java.lang.Exception

suspend fun <T : Any> executeLocalRequest(request: suspend () -> T?): Result<T> {
    return try {
        val response = request()
        if (response != null)
            Result.Success(response)
        else Result.Error(Failure.ResponseIsNullError)
    } catch (e: Exception) {
        Result.Error(e.parseLocalError())
    }
}