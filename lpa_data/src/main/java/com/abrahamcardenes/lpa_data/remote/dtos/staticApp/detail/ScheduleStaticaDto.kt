package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScheduleStaticaDto(
    @SerialName(value = "node")
    val node: String,
    @SerialName(value = "tipology")
    val tipology: String,
    @SerialName(value = "time")
    val time: String,
    @SerialName(value = "color")
    val color: String,
    @SerialName(value = "variant")
    val variant: String? = null
)
