package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllBusStops
@Inject
constructor(
    private val repository: BusStopsRepository
) {
    private var currentBusStops: List<BusStop> = emptyList()

    operator fun invoke(): Flow<List<BusStop>> {
        val busStopsCombinedWithLocal = repository.getAllLocalBusStops().map { savedStops ->
            currentBusStops.ifEmpty { currentBusStops = getNetworkBusStops() }
            val savedStopsMap = savedStops.associateBy({ it.stopNumber }, { it.isSavedInDb })
            currentBusStops.map { busStop ->
                busStop.copy(isSavedInDb = savedStopsMap[busStop.stopNumber] ?: false)
            }
        }
        return busStopsCombinedWithLocal
    }

    private suspend fun getNetworkBusStops() = repository
        .getBusStops()
        .distinctBy { it.stopNumber }
        .sortedBy { it.stopNumber }
}
