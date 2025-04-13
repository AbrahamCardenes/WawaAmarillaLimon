package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LineRootDto(
    @field:Json(name = "Respuesta")
    val response: LineResponseDto
)
