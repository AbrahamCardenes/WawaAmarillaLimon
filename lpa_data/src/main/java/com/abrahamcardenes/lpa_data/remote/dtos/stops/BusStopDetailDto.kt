package com.abrahamcardenes.lpa_data.remote.dtos.stops

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BusStopDetailDto(
    @SerialName(value = "nombre")
    val addressName: String,
    @SerialName(value = "lineas")
    val lines: List<BusLineDto>
)
