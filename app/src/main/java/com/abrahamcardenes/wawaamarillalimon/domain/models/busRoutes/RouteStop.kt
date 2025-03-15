package com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.GpsCoordinates
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.VariantLetter

data class RouteStop(
    val number: String,
    val name: String,
    val gpsCoordinates: GpsCoordinates?,
    val node: String,
    val variants: List<VariantLetter>
)
