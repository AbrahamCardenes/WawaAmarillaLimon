package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.detail

import com.abrahamcardenes.lpa_domain.valueObjects.RgbString
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VariantsDto(
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "color")
    val color: RgbString
)
