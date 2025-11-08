package com.abrahamcardenes.core_android.firebase

fun interface CrashlyticsService {
    suspend fun logException(throwable: Throwable)
}
