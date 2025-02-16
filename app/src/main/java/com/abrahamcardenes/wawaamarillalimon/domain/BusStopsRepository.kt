package com.abrahamcardenes.wawaamarillalimon.domain

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import kotlinx.coroutines.flow.Flow

interface BusStopsRepository {
    suspend fun getBusStops(): Result<List<BusStop>, DataError>

    fun getBusDetailStop(stopNumber: BusStopNumber): Flow<Result<BusStopDetail?, DataError>>
    suspend fun saveStops(busStop: BusStop)

    fun getAllLocalBusStops(): Flow<List<BusStop>>
    suspend fun deleteBusStop(busStop: BusStop)
}
