package com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoutePathsDto(
    @SerialName(value = "Tipo")
    val type: String,
    @SerialName(value = "Color")
    val hexColour: String,
    @SerialName(value = "Observaciones")
    val observations: String
)
