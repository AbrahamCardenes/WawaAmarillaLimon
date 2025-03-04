package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimetablesDto(
    @field:Json(name = "Horarios")
    val timetable: List<TimetableDto>
)
