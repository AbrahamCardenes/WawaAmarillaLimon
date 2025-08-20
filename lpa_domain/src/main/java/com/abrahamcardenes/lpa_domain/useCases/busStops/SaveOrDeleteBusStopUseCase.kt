package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsEvents
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsParams
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import javax.inject.Inject

class SaveOrDeleteBusStopUseCase @Inject constructor(
    private val busStopsRepository: BusStopsRepository,
    private val analyticsServiceImpl: AnalyticsService
) {
    suspend operator fun invoke(busStop: BusStop) {
        if (busStop.isSavedInDb) {
            sendEvent(
                event = AnalyticsEvents.UNFAVORITE_CLICKED,
                busStop = busStop
            )
            busStopsRepository.deleteBusStop(busStop)
        } else {
            sendEvent(
                event = AnalyticsEvents.FAVORITE_CLICKED,
                busStop = busStop
            )
            busStopsRepository.saveStops(busStop)
        }
    }

    private fun sendEvent(event: AnalyticsEvents, busStop: BusStop) {
        analyticsServiceImpl.sendLogEvent(
            event = event,
            Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
            Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
        )
    }
}
