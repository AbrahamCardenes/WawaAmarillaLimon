package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusTimetablesDto(
    @field:Json(name = "Horarios")
    val timetables: List<TimetableDto>
)
