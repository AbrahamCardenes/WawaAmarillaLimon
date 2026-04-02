package com.abrahamcardenes.lpa_data.remote.dtos.stops

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BusLineDto(
    @SerialName(value = "numero")
    val number: String,
    @SerialName(value = "llegada")
    val arrivalTimeIn: String,
    @SerialName(value = "destino")
    val destination: String
)
