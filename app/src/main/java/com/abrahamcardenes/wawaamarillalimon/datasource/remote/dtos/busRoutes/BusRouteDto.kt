package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes

import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.BusRoute
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

fun BusRouteDto.toDomain(): BusRoute {
    return BusRoute(
        line = line,
        name = name,
        color = color,
        nodes = nodes,
        variantsGo = variantsGo,
        variantsBack = variantsBack,
        stops = stops
    )
}

typealias RgbStringColor = String