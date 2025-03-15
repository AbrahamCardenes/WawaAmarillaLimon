package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BusRouteDto(
    @field:Json(name = "line")
    val line: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "color")
    val color: String,
    @field:Json(name = "nodes")
    val nodes: List<String>,
    @field:Json(name = "variantsGo")
    val variantsGo: List<VariantsDto>,
    @field:Json(name = "variantsBack")
    val variantsBack: List<VariantsDto>,
    @field:Json(name = "stops")
    val stops: List<RouteStopsDto>
)
