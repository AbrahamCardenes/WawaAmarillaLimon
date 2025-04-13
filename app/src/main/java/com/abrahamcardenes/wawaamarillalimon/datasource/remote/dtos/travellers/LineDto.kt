package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers

import com.abrahamcardenes.lpa_domain.models.travellers.Concession
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

fun List<LineDto>.toDomain(): List<Concession> = this.map {
    it.toDomain()
}

fun LineDto.toDomain(): Concession = Concession(
    busNumber = this.busNumber,
    name = this.name,
    commercialName = this.commercialName,
    color = this.color
)
