package com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis

import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.stops.BusStopDetailDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.stops.BusStopDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiParadas {
    @GET("paradas")
    suspend fun getParadas(): Response<List<BusStopDto>>

    @GET("parada/{busStopNumber}")
    suspend fun getBusStopDetail(@Path("busStopNumber") busStopNumber: BusStopNumber): Response<BusStopDetailDto>
}
