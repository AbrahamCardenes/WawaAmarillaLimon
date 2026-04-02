package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import com.abrahamcardenes.lpa_domain.valueObjects.RgbString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConcessionStaticAppDto(
    @SerialName(value = "Nombre")
    val name: String,
    @SerialName(value = "Comercial")
    val commercial: String,
    @SerialName(value = "Color")
    val color: RgbString
)
