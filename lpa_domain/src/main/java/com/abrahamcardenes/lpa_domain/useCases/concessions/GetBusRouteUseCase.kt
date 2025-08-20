package com.abrahamcardenes.lpa_domain.useCases.concessions

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsEvents
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsParams
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsService
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.repositories.BusRoutesRepository
import javax.inject.Inject

class GetBusRouteUseCase @Inject constructor(
    private val busRoutesRepository: BusRoutesRepository,
    private val analyticsService: AnalyticsService
) {
    suspend operator fun invoke(concessionId: String): Result<BusRoute, DataError> {
        val concessionIdLowerCase = concessionId.lowercase()
        analyticsService.sendLogEvent(
            event = AnalyticsEvents.CONCESSION_LOOK_UP,
            params = arrayOf(
                Pair(AnalyticsParams.CONCESSION_ID, concessionIdLowerCase)
            )
        )
        return busRoutesRepository.getBusRoutes(concessionId = concessionIdLowerCase)
    }
}
