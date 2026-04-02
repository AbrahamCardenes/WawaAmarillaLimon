package com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BusTimetablesDto(
    @SerialName(value = "Horarios")
    val timetables: List<TimetableDto>
)
