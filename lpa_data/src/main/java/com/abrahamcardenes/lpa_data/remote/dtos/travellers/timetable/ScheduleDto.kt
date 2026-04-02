package com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScheduleDto(
    @SerialName(value = "Tipologia")
    val availableDays: String,
    @SerialName(value = "Hora")
    val times: List<String>
)
