package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto(
    @SerialName(value = "Concesiones")
    val concessionsDto: ConcessionsDto
)
