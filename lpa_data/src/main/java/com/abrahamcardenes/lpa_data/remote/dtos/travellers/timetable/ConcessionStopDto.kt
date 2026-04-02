package com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConcessionStopDto(
    @SerialName(value = "NombreParada")
    val name: String,
    @SerialName(value = "Tipo")
    val type: List<String>
)
