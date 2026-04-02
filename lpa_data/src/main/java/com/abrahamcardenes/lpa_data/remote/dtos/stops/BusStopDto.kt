package com.abrahamcardenes.lpa_data.remote.dtos.stops

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BusStopDto(
    @SerialName(value = "nombre") val addressName: String,
    @SerialName(value = "numero")
    val stopNumber: String
)
