package com.abrahamcardenes.wawaamarillalimon.datasource

import com.abrahamcardenes.wawaamarillalimon.datasource.dtos.BusStopDetailDto
import com.abrahamcardenes.wawaamarillalimon.datasource.dtos.BusStopDto
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiParadas {
    @GET("paradas")
    suspend fun getParadas(): List<BusStopDto>

    @GET("parada/{busStopNumber}")
    suspend fun getBusStopDetail(@Path("busStopNumber") busStopNumber: BusStopNumber): BusStopDetailDto
}
