package com.abrahamcardenes.core_android.firebase

import com.google.firebase.crashlytics.FirebaseCrashlytics

interface CrashlyticsService {
    suspend fun logException(throwable: Throwable)
    suspend fun logException(e: Exception)
}

class CrashlyticsServiceImpl(val firebaseCrashlytics: FirebaseCrashlytics) : CrashlyticsService {
    override suspend fun logException(throwable: Throwable) {
        firebaseCrashlytics.recordException(throwable)
    }

    override suspend fun logException(e: Exception) {
        firebaseCrashlytics.recordException(e)
    }
}
