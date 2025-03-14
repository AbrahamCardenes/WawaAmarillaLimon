package com.abrahamcardenes.wawaamarillalimon.domain.repositories

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result

interface BusRoutesRepository {
    suspend fun getBusRoutes(busNumber: String): Result<String, DataError>
}
