package com.abrahamcardenes.wawaamarillalimon.domain.repositories

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import kotlinx.coroutines.flow.Flow

interface BusStopsRepository {
    suspend fun getBusStops(): Result<List<BusStop>, DataError>

    fun getBusDetailStop(stopNumber: BusStopNumber): Flow<Result<BusStopDetail?, DataError>>
    suspend fun saveStops(busStop: BusStop)

    fun getAllLocalBusStops(): Flow<List<BusStop>>
    suspend fun deleteBusStop(busStop: BusStop)
}
