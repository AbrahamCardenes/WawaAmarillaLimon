package com.abrahamcardenes.wawaamarillalimon.domain.repositories

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.BusRoute

interface BusRoutesRepository {
    suspend fun getBusRoutes(busNumber: String): Result<BusRoute, DataError>
}
