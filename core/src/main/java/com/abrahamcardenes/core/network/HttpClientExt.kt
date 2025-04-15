package com.abrahamcardenes.core.network

import com.squareup.moshi.JsonDataException
import java.net.SocketTimeoutException
import java.nio.channels.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import retrofit2.Response

suspend inline fun <reified T> safecall(execute: () -> Response<T>): Result<T, DataError> {
    val response =
        try {
            execute()
        } catch (_: SocketTimeoutException) {
            return Result.Error(DataError.Remote.RequestTimeout)
        } catch (_: UnresolvedAddressException) {
            return Result.Error(DataError.Remote.NoInternet)
        } catch (_: JsonDataException) {
            return Result.Error(DataError.Remote.Serialization)
        } catch (e: Exception) {
            return Result.Error(DataError.Remote.UnknownError(e))
        }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(response: Response<T>): Result<T, DataError.Remote> = when (response.code()) {
    in 200..299 -> {
        try {
            Result.Success(response.body() as T)
        } catch (e: SerializationException) {
            Result.Error(DataError.Remote.Serialization)
        }
    }

    400 -> Result.Error(DataError.Remote.BadRequest)
    401 -> Result.Error(DataError.Remote.Unauthorized)
    404 -> Result.Error(DataError.Remote.NotFound)
    408 -> Result.Error(DataError.Remote.RequestTimeout)
    429 -> Result.Error(DataError.Remote.TooManyRequests)
    in 500..599 -> Result.Error(DataError.Remote.ServerFailure)

    else -> Result.Error(DataError.Remote.UnknownError(Exception("Unknown error code ${response.code()}")))
}
