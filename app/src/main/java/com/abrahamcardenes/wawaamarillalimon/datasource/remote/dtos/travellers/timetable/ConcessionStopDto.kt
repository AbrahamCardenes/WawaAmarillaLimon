package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConcessionStopDto(
    @field:Json(name = "NombreParada")
    val name: String,
    @field:Json(name = "Tipo")
    val type: List<String>
)
