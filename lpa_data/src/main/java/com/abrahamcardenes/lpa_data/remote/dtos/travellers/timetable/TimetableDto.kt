package com.abrahamcardenes.lpa_data.remote.dtos.travellers.timetable

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimetableDto(
    @SerialName(value = "Linea_ID")
    val lineId: String,
    @SerialName(value = "Nodo")
    val node: String,
    @SerialName(value = "Aviso")
    val warning: String,
    @SerialName(value = "Observaciones")
    val observations: String,
    @SerialName(value = "TiposTrayectos")
    val routes: List<RoutePathsDto>,
    @SerialName(value = "ListaParadas")
    val concessionStops: List<ConcessionStopDto>,
    @SerialName(value = "Tipologias")
    val schedules: List<ScheduleDto>
)
