package com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes

import com.abrahamcardenes.lpa_domain.models.common.RGBAColor

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
