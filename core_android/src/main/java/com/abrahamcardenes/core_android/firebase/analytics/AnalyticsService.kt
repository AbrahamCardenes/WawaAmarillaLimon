package com.abrahamcardenes.core_android.firebase.analytics

fun interface AnalyticsService {
    fun sendLogEvent(event: AnalyticsEvents, vararg params: Pair<AnalyticsParams, Any>)
}
