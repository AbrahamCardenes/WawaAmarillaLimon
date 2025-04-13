package com.abrahamcardenes.lpa_data.remote.apis

import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import com.abrahamcardenes.lpa_data.remote.dtos.stops.BusStopDetailDto
import com.abrahamcardenes.lpa_data.remote.dtos.stops.BusStopDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiParadas {
    @GET("paradas")
    suspend fun getParadas(): Response<List<BusStopDto>>

    @GET("parada/{busStopNumber}")
    suspend fun getBusStopDetail(@Path("busStopNumber") busStopNumber: BusStopNumber): Response<BusStopDetailDto>
}
