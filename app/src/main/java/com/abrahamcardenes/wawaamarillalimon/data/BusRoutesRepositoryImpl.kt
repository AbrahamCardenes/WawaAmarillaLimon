package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.map
import com.abrahamcardenes.core.network.safecall
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.lpa_domain.repositories.BusRoutesRepository
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toDomain
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp

class BusRoutesRepositoryImpl(private val apiService: ApiStaticApp) : BusRoutesRepository {
    override suspend fun getLines(): Result<Concessions, DataError> = safecall {
        apiService.getLines()
    }.map {
        it.response.concessionsDto.toDomain()
    }

    override suspend fun getBusRoutes(busNumber: String): Result<BusRoute, DataError.Remote> {
        val busRouteDto = safecall {
            apiService.getBusRoute(busNumber)
        }
        return busRouteDto.map { it.toDomain() }
    }
}
