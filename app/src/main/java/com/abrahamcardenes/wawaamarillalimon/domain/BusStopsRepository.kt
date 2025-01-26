package com.abrahamcardenes.wawaamarillalimon.domain

import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import kotlinx.coroutines.flow.Flow

interface BusStopsRepository {
    suspend fun getBusStops(): List<BusStop>

    fun getBusDetailStop(stopNumber: BusStopNumber): Flow<BusStopDetail?>
    suspend fun saveStops(busStop: BusStop)

    fun getAllLocalBusStops(): Flow<List<BusStop>>
    suspend fun deleteBusStop(busStop: BusStop)
}
