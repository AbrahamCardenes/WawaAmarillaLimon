package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.core.DataError
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.core.map
import com.abrahamcardenes.wawaamarillalimon.core.safecall
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toDomain
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusRoutesRepository

class BusRoutesRepositoryImpl(private val apiService: ApiStaticApp) : BusRoutesRepository {
    override suspend fun getLines(): Result<Concessions, DataError> {
        return safecall {
            apiService.getLines()
        }.map {
            it.response.concessionsDto.toDomain()
        }


    }

    override suspend fun getBusRoutes(busNumber: String): Result<BusRoute, DataError.Remote> {
        val busRouteDto = safecall {
            apiService.getBusRoute(busNumber)
        }
        return busRouteDto.map { it.toDomain() }
    }
}
