package com.abrahamcardenes.core_android.firebase

import com.google.firebase.crashlytics.FirebaseCrashlytics

class CrashlyticsServiceImpl(val firebaseCrashlytics: FirebaseCrashlytics) : CrashlyticsService {
    override suspend fun logException(throwable: Throwable) {
        firebaseCrashlytics.recordException(throwable)
    }
}
