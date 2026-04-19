package com.abrahamcardenes.lpa_domain.repositories

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.EmptyResult
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import kotlinx.coroutines.flow.Flow

interface BusStopsRepository {
    suspend fun getBusStops(): EmptyResult<DataError>
    fun getBusDetailStop(stopNumber: BusStopNumber): Flow<Result<BusStopDetail?, DataError>>
    suspend fun updateBusStopInDb(busStop: BusStop)

    fun getAllLocalBusStops(): Flow<List<BusStop>>
}
