package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import com.abrahamcardenes.lpa_domain.valueObjects.RgbaStringColor
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConcessionStaticAppDto(
    @field:Json(name = "Nombre")
    val name: String,
    @field:Json(name = "Comercial")
    val commercial: String,
    @field:Json(name = "Color")
    val color: RgbaStringColor
)
