package com.abrahamcardenes.wawaamarillalimon.domain

interface BusStopsRepository {
    suspend fun getStops(): List<BusStop>
    suspend fun getStopByNumber(stopNumber: String): BusStopDetail
//    suspend fun saveStops(stops: List<BusStop>)
}