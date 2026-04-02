package com.abrahamcardenes.lpa_data.remote.dtos.travellers

import com.abrahamcardenes.core.serializationUtils.FlexibleStringSerializer
import com.abrahamcardenes.lpa_domain.models.travellers.Concession
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LineDto(
    @SerialName(value = "Numero")
    val busNumber: Int,
    @SerialName(value = "Nombre")
    val name: String,
    @Serializable(with = FlexibleStringSerializer::class)
    @SerialName(value = "Comercial")
    val commercialName: String,
    @SerialName(value = "Color")
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
