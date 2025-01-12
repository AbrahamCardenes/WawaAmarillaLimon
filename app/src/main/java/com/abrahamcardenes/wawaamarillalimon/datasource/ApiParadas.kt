package com.abrahamcardenes.wawaamarillalimon.datasource

import com.abrahamcardenes.wawaamarillalimon.datasource.dtos.BusStopDto
import retrofit2.http.GET


interface ApiParadas {
    @GET("paradas")
    suspend fun getParadas(): List<BusStopDto>
}

