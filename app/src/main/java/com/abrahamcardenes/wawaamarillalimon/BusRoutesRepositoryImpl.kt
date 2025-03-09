package com.abrahamcardenes.wawaamarillalimon

import com.abrahamcardenes.wawaamarillalimon.core.onError
import com.abrahamcardenes.wawaamarillalimon.core.onSuccess
import com.abrahamcardenes.wawaamarillalimon.core.safecall
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
import com.abrahamcardenes.wawaamarillalimon.domain.BusRoutesRepository

class BusRoutesRepositoryImpl(private val apiService: ApiStaticApp) : BusRoutesRepository {
    override suspend fun getBusRoutes(busNumber: String) {
        val busRouteDto = safecall {
            apiService.getBusRoute(busNumber)
        }

        busRouteDto
            .onSuccess {
                println("BusRouteRepository: $it")
            }
            .onError {
                println("BusRouteRepository: $it")
            }
    }
}
