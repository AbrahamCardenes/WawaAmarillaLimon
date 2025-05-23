package com.abrahamcardenes.lpa_data.remote.dtos.stops

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusLineDto(
    @field:Json(name = "numero")
    val number: String,
    @field:Json(name = "llegada")
    val arrivalTimeIn: String,
    @field:Json(name = "destino")
    val destination: String
)
