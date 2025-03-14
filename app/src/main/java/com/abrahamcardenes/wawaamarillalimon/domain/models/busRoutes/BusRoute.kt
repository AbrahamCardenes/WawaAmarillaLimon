package com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes

import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes.RgbStringColor
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes.RouteStopsDto
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.dtos.busRoutes.VariantsDto

data class BusRoute(
    val line: String,
    val name: String,
    val color: RgbStringColor,
    val nodes: List<String>,
    val variantsGo: List<VariantsDto>,
    val variantsBack: List<VariantsDto>,
    val stops: List<RouteStopsDto>
)