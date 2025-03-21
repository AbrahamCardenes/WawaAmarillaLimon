package com.abrahamcardenes.wawaamarillalimon.domain.repositories

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions.Concessions

interface BusRoutesRepository {
    suspend fun getLines(): Result<Concessions, DataError>
    suspend fun getBusRoutes(busNumber: String): Result<BusRoute, DataError>
}
