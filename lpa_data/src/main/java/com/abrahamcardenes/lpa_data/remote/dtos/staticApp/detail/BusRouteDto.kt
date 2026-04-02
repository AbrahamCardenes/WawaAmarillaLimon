package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail

import com.abrahamcardenes.lpa_domain.valueObjects.RgbString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BusRouteDto(
    @SerialName(value = "line")
    val line: String,
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "color")
    val color: RgbString,
    @SerialName(value = "nodes")
    val nodes: List<String>,
    @SerialName(value = "variantsGo")
    val variantsGo: List<VariantsDto>,
    @SerialName(value = "variantsBack")
    val variantsBack: List<VariantsDto>,
    @SerialName(value = "stops")
    val stops: List<RouteStopsDto>,
    @SerialName(value = "schedule")
    val schedule: List<ScheduleStaticaDto>
)
