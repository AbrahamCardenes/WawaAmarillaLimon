package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail

import com.abrahamcardenes.lpa_domain.valueObjects.RgbString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VariantsDto(
    @SerialName(value = "type")
    val type: String,
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "color")
    val color: RgbString
)
