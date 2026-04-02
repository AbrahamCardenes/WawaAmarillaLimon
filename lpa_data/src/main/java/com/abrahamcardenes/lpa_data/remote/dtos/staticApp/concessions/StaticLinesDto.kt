package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StaticLinesDto(
    @SerialName(value = "Respuesta")
    val response: ResponseDto
)
