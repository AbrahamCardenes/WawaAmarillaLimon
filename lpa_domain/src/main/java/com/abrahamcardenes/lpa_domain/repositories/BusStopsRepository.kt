package com.abrahamcardenes.lpa_domain.repositories

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import kotlinx.coroutines.flow.Flow

interface BusStopsRepository {
    suspend fun getBusStops(): Result<List<BusStop>, DataError>
    fun getBusDetailStop(stopNumber: BusStopNumber): Flow<Result<BusStopDetail?, DataError>>
    suspend fun saveStops(busStop: BusStop)

    fun getAllLocalBusStops(): Flow<List<BusStop>>

    @Deprecated("Not in use anymore with offline first approach")
    suspend fun deleteBusStop(busStop: BusStop)
}
