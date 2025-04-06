package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.staticApp.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScheduleStaticaDto(
    @field:Json(name = "node")
    val node: String,
    @field:Json(name = "tipology")
    val tipology: String,
    @field:Json(name = "time")
    val time: String,
    @field:Json(name = "color")
    val color: String,
    @field:Json(name = "variant")
    val variant: String?
)
