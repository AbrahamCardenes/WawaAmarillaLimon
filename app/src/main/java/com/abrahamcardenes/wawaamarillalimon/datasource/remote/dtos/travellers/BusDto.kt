package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LineDto(
    @field:Json(name = "Numero")
    val busNumber: Int,
    @field:Json(name = "Nombre")
    val name: String,
    @field:Json(name = "Comercial")
    val commercialName: String,
    @field:Json(name = "Color")
    val color: String
)

@JsonClass(generateAdapter = true)
data class LineRootDto(
    @field:Json(name = "Respuesta")
    val response: LineResponseDto
)

@JsonClass(generateAdapter = true)
data class LineResponseDto(
    @field:Json(name = "Concesiones")
    val concessions: ConcessionDto
)

@JsonClass(generateAdapter = true)
data class ConcessionDto(
    @field:Json(name = "Concesion")
    val lines: List<LineDto>
)
