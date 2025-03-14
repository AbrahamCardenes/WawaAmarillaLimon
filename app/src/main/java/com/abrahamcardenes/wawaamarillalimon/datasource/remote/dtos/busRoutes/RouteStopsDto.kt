package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RouteStopsDto(
    @field:Json(name = "number")
    val number: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "longitude")
    val longitude: String,
    @field:Json(name = "latitude")
    val latitude: String,
    @field:Json(name = "node")
    val node: String,
    @field:Json(name = "variants")
    val variants: List<String>
)