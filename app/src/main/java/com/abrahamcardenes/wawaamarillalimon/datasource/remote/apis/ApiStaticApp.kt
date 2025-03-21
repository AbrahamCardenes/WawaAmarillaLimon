package com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis

import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.staticApp.concessions.StaticLinesDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.staticApp.detail.BusRouteDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiStaticApp {

    @GET("lines.json")
    suspend fun getLines(): Response<StaticLinesDto>

    @GET("{busCommercialNumber}.json")
    suspend fun getBusRoute(@Path("busCommercialNumber") busCommercialName: String): Response<BusRouteDto>
}
