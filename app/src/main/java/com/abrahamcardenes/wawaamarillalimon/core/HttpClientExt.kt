package com.abrahamcardenes.wawaamarillalimon.core

import android.util.Log
import kotlinx.serialization.SerializationException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.nio.channels.UnresolvedAddressException


suspend inline fun <reified T> safecall(execute: () -> Response<T>): Result<T, DataError.Remote> {
    val response =
        try {
            execute()
        } catch (e: SocketTimeoutException) {
            return Result.Error(DataError.Remote.REQUEST_TIMEOUT)
        } catch (e: UnresolvedAddressException) {
            return Result.Error(DataError.Remote.NO_INTERNET)
        } catch (e: Exception) {
            Log.e("HttpClientExt", "safecall: ${e.stackTraceToString()}")
            return Result.Error(DataError.Remote.UNKNOWN)
        }
    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(response: Response<T>): Result<T, DataError.Remote> {
    return when (response.code()) {
        in 200..299 -> {
            try {
                Result.Success(response.body() as T)
            } catch (e: SerializationException) {
                Result.Error(DataError.Remote.SERIALIZATION)
            }
        }

        408 -> Result.Error(DataError.Remote.REQUEST_TIMEOUT)
        429 -> Result.Error(DataError.Remote.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(DataError.Remote.SERVER)

        else -> Result.Error(DataError.Remote.UNKNOWN)
    }
}