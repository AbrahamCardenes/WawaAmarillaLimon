package com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.RgbStringColor

data class BusRoute(
    val line: String,
    val name: String,
    val color: RgbStringColor,
    val nodes: List<String>,
    val variantsGo: List<Variants>,
    val variantsBack: List<Variants>,
    val stops: List<RouteStop>
)
