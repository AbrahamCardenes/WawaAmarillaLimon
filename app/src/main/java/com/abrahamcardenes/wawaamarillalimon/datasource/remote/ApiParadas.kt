package com.abrahamcardenes.wawaamarillalimon.datasource.remote

import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.BusStopDetailDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.BusStopDto
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiParadas {
    @GET("paradas")
    suspend fun getParadas(): List<BusStopDto>

    @GET("paradas")
    suspend fun getParadas2(): Response<List<BusStopDto>>

    @GET("parada/{busStopNumber}")
    suspend fun getBusStopDetail(@Path("busStopNumber") busStopNumber: BusStopNumber): BusStopDetailDto
}
