package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsEvents
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsParams
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import javax.inject.Inject

class UpdateLocalBusStopUseCase @Inject constructor(
    private val busStopsRepository: BusStopsRepository,
    private val analyticsService: AnalyticsService
) {
    suspend operator fun invoke(busStop: BusStop) {
        if (busStop.isFavorite) {
            sendEvent(
                event = AnalyticsEvents.UNFAVORITE_CLICKED,
                busStop = busStop
            )
            busStopsRepository.updateBusStopInDb(busStop.copy(isFavorite = false))
        } else {
            sendEvent(
                event = AnalyticsEvents.FAVORITE_CLICKED,
                busStop = busStop
            )
            busStopsRepository.updateBusStopInDb(busStop.copy(isFavorite = true))
        }
    }

    private fun sendEvent(event: AnalyticsEvents, busStop: BusStop) {
        analyticsService.sendLogEvent(
            event = event,
            params = arrayOf(
                Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
            )
        )
    }
}
