package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimetableDto(
    @field:Json(name = "Linea_ID")
    val lineId: String,
    @field:Json(name = "Nodo")
    val node: String
)
