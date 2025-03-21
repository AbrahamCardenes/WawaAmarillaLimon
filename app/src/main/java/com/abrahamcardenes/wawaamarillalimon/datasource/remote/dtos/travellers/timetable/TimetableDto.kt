package com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.travellers.timetable

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimetableDto(
    @field:Json(name = "Linea_ID")
    val lineId: String,
    @field:Json(name = "Nodo")
    val node: String,
    @field:Json(name = "Aviso")
    val warning: String,
    @field:Json(name = "Observaciones")
    val observations: String,
    @field:Json(name = "TiposTrayectos")
    val routes: List<RoutePathsDto>,
    @field:Json(name = "ListaParadas")
    val concessionStops: List<ConcessionStopDto>,
    @field:Json(name = "Tipologias")
    val schedules: List<ScheduleDto>
)
