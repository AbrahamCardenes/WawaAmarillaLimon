package com.abrahamcardenes.wawaamarillalimon.datasource.dtos

import com.abrahamcardenes.wawaamarillalimon.domain.BusStop
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusStopDto(
    @field:Json(name = "nombre")
    val addressName: String,
    @field:Json(name = "numero")
    val stopNumber: String
)
