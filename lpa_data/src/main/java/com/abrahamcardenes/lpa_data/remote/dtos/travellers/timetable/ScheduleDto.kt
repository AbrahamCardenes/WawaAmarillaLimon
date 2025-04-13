package com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScheduleDto(
    @field:Json(name = "Tipologia")
    val availableDays: String,
    @field:Json(name = "Hora")
    val times: List<String>
)
