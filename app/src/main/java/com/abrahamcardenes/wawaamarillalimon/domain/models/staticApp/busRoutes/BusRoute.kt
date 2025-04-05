package com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor

data class BusRoute(
    val line: String,
    val name: String,
    val color: RGBAColor,
    val nodes: List<String>,
    val variantsGo: List<Variants>,
    val variantsBack: List<Variants>,
    val stops: List<RouteStop>,
    val schedules: List<BusSchedule>
)
