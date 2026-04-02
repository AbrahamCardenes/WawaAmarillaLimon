package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LineResponseDto(
    @SerialName(value = "Concesiones")
    val concessions: ConcessionDto
)
