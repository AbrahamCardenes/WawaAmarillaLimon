package com.abrahamcardenes.core.network

sealed interface DataError : Error {
    sealed class Remote() : DataError {
        data object RequestTimeout : Remote()
        data object TooManyRequests : Remote()
        data object NoInternet : Remote()
        data object ServerFailure : Remote()
        data object Serialization : Remote()
        data class UnknownError(val error: Throwable?) : Remote()
        data object BadRequest : Remote()
        data object Unauthorized : Remote()
        data object NotFound : Remote()
    }

    enum class Local : DataError {
        DISK_FULL,
        CANCELLED_EXCEPTION,
        UNKNOWN
    }
}
