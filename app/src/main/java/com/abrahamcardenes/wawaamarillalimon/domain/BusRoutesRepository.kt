package com.abrahamcardenes.wawaamarillalimon.domain

interface BusRoutesRepository {
    suspend fun getBusRoutes(busNumber: String)
}
