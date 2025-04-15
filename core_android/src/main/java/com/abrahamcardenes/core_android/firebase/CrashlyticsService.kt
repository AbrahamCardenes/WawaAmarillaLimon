package com.abrahamcardenes.core_android.firebase

interface CrashlyticsService {
    suspend fun logException(throwable: Throwable)
    suspend fun logException(e: Exception)
}
