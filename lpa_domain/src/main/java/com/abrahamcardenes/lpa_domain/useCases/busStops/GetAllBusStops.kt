package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.map
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Deprecated("Not in use anymore with offline first approach")
class GetAllBusStops
@Inject
constructor(
    private val repository: BusStopsRepository
) {
    private lateinit var currentBusStops: Result<List<BusStop>, DataError>

    operator fun invoke(): Flow<Result<List<BusStop>, DataError>> {
        val busStopsCombinedWithLocal = repository.getAllLocalBusStops().map { savedStops ->
            if (!::currentBusStops.isInitialized || currentBusStops is Result.Error) {
                currentBusStops = fetchBusStops()
            }

            val savedStopsMap = savedStops.associateBy({ it.stopNumber }, { it.isFavorite })

            currentBusStops.map { currentBusStops ->
                currentBusStops.map { busStop ->
                    busStop.copy(isFavorite = savedStopsMap[busStop.stopNumber] ?: false)
                }
            }
        }

        return busStopsCombinedWithLocal
    }

    suspend fun fetchBusStops() = repository
        .getBusStops().map { busStop ->
            busStop.distinctBy { it.stopNumber }
                .sortedBy { it.stopNumber }
        }
}
