package com.abrahamcardenes.lpa_data.remote.dtos.staticApp.concessions

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StaticLinesDto(
    @field:Json(name = "Respuesta")
    val response: ResponseDto
)
