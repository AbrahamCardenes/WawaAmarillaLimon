package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LineResponseDto(
    @field:Json(name = "Concesiones")
    val concessions: ConcessionDto
)
