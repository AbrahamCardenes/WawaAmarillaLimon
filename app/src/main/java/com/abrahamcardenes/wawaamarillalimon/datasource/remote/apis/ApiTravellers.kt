package com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis

import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.LineRootDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiTravellers {
    @GET("jersey/lineas")
    suspend fun getBuses(): Response<LineRootDto>
}
