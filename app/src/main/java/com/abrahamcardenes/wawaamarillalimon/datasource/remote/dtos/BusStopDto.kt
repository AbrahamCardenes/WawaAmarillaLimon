package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusStopDto(
    @field:Json(name = "nombre")
    val addressName: String,
    @field:Json(name = "numero")
    val stopNumber: String
)
