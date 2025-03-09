package com.abrahamcardenes.wawaamarillalimon.domain.repositories

interface BusRoutesRepository {
    suspend fun getBusRoutes(busNumber: String)
}
