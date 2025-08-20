package com.abrahamcardenes.core_android.firebase.analytics

interface AnalyticsService {
    fun sendLogEvent(event: AnalyticsEvents, vararg params: Pair<AnalyticsParams, Any>)
}
