package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConcessionsDto(
    @SerialName(value = "Concesion")
    val concessions: List<ConcessionStaticAppDto>
)
