package com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.map
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusStopsRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllBusStops
@Inject
constructor(
    private val repository: BusStopsRepository
) {
    private lateinit var currentBusStops: Result<List<BusStop>, DataError>

    operator fun invoke(): Flow<Result<List<BusStop>, DataError>> {
        val busStopsCombinedWithLocal = repository.getAllLocalBusStops().map { savedStops ->
            if (!::currentBusStops.isInitialized) {
                currentBusStops = getNetworkBusStops()
            }

            val savedStopsMap = savedStops.associateBy({ it.stopNumber }, { it.isSavedInDb })

            currentBusStops.map { currentBusStops ->
                currentBusStops.map { busStop ->
                    busStop.copy(isSavedInDb = savedStopsMap[busStop.stopNumber] ?: false)
                }
            }
        }

        return busStopsCombinedWithLocal
    }

    private suspend fun getNetworkBusStops() = repository
        .getBusStops().map { it ->
            it.distinctBy { it.stopNumber }
                .sortedBy { it.stopNumber }
        }
}
