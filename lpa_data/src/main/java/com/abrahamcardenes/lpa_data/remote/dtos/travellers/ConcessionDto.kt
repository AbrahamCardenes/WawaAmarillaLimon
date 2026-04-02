package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConcessionDto(
    @SerialName(value = "Concesion")
    val lines: List<LineDto>
)
