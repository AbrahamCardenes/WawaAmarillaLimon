package com.abrahamcardenes.core_android.firebase.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsServiceImpl(private val firebaseAnalytics: FirebaseAnalytics) : AnalyticsService {

    override fun sendLogEvent(event: AnalyticsEvents, vararg params: Pair<AnalyticsParams, Any>) {
        val bundle = Bundle().apply {
            params.forEach { (param, value) ->
                when (value) {
                    is String -> putString(param.value, value)
                    is Int -> putInt(param.value, value)
                    is Long -> putLong(param.value, value)
                    is Float -> putFloat(param.value, value)
                    is Double -> putDouble(param.value, value)
                    is Boolean -> putBoolean(param.value, value)
                    else -> throw IllegalArgumentException("Unsupported type for Firebase Analytics parameter, value: $value")
                }
            }
        }
        firebaseAnalytics.logEvent(event.value, bundle)
    }
}
