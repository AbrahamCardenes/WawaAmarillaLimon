package com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RoutePathsDto(
    @field:Json(name = "Tipo")
    val type: String,
    @field:Json(name = "Color")
    val hexColour: String,
    @field:Json(name = "Observaciones")
    val observations: String
)
