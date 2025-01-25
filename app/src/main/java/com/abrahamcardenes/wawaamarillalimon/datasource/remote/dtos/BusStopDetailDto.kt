package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusStopDetailDto(
    @field:Json(name = "nombre")
    val addressName: String,
    @field:Json(name = "lineas")
    val lines: List<BusLineDto>
)
