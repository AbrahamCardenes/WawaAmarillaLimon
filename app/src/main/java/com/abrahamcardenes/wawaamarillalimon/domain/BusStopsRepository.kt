package com.abrahamcardenes.wawaamarillalimon.domain

import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail

interface BusStopsRepository {
    suspend fun getStops(): List<BusStop>
    suspend fun getStopByNumber(stopNumber: String): BusStopDetail
//    suspend fun saveStops(stops: List<BusStop>)
}