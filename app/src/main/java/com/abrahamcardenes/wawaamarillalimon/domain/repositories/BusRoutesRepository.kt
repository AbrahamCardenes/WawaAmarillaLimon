package com.abrahamcardenes.wawaamarillalimon.domain.repositories

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions.Concessions

interface BusRoutesRepository {
    suspend fun getLines(): Result<Concessions, DataError>
    suspend fun getBusRoutes(concessionId: String): Result<BusRoute, DataError>
}
