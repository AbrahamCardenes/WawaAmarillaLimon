package com.abrahamcardenes.lpa_data.remote.apis

import com.abrahamcardenes.lpa_data.remote.dtos.travellers.LineRootDto
import com.abrahamcardenes.lpa_data.remote.dtos.travellers.WawaCardBalanceDto
import com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable.BusTimetablesDto
import com.abrahamcardenes.lpa_domain.valueObjects.BusIdNumber
import com.abrahamcardenes.lpa_domain.valueObjects.WawaCardNumber
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiTravellers {
    @GET("jersey/lineas")
    suspend fun getBuses(): Response<LineRootDto>

    @GET("jersey/lineas/{busIdNumber}/horariosweb")
    suspend fun getTimetable(@Path("busIdNumber") busIdNumber: BusIdNumber): Response<BusTimetablesDto>

    @GET("jersey/obtenersaldo")
    suspend fun getBalance(@Query("codigo") cardNumber: WawaCardNumber): Response<WawaCardBalanceDto>
}
