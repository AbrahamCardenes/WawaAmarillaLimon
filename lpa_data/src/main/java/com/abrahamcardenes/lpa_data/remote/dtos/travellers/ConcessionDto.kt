package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConcessionDto(
    @field:Json(name = "Concesion")
    val lines: List<LineDto>
)
