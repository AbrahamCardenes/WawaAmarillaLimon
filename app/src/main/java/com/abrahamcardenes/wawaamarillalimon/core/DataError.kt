package com.abrahamcardenes.wawaamarillalimon.core

sealed interface DataError : Error {
    enum class Remote : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        SERVER,
        SERIALIZATION,
        UNKNOWN,
        BAD_REQUEST,
        UNAUTHORIZED,
        NOT_FOUND
    }

    enum class Local : DataError {
        DISK_FULL,
        CANCELLED_EXCEPTION,
        UNKNOWN
    }
}
