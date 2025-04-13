package com.abrahamcardenes.core.network

sealed interface Result<out D, out E : Error> {
    data class Success<out D>(val data: D) : Result<D, Nothing>
    data class Error<out E : com.abrahamcardenes.core.network.Error>(
        val error: E
    ) : Result<Nothing, E>
}

inline fun <T, E : Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> = when (this) {
    is Result.Error -> Result.Error(error)
    is Result.Success -> Result.Success(map(data))
}

inline fun <T, E : Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> = when (this) {
    is Result.Error -> this
    is Result.Success -> {
        action(data)
        this
    }
}

inline fun <T, E : Error> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> = when (this) {
    is Result.Error -> {
        action(error)
        this
    }
    is Result.Success -> {
        this
    }
}

fun <T, E : Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> = map {}

typealias EmptyResult<E> = Result<Unit, E>
