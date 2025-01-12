package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.data.mappers.toDomain
import com.abrahamcardenes.wawaamarillalimon.datasource.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.domain.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository

class BusStopsRepositoryImpl(
    private val api: ApiParadas
) : BusStopsRepository {
    override suspend fun getStops(): List<BusStop> {
        return try {
            val originalBusStops = api.getParadas().toMutableList()
            originalBusStops.removeIf { it.stopNumber == "PAR" || it.addressName == "NOMBRE" }
            originalBusStops.toDomain()
        } catch (e: Exception) {
            println(e.stackTraceToString())
            emptyList()
        }
    }

    override suspend fun getStopByNumber(stopNumber: String): BusStopDetail {
        TODO("Not yet implemented")
    }
}

