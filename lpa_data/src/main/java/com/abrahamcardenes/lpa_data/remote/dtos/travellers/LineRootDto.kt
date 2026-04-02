package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LineRootDto(
    @SerialName(value = "Respuesta")
    val response: LineResponseDto
)
