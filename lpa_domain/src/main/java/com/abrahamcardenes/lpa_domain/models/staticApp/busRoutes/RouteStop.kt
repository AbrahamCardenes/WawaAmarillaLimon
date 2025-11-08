package com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes

import com.abrahamcardenes.lpa_domain.models.common.GpsCoordinates
import com.abrahamcardenes.lpa_domain.valueObjects.VariantLetter

data class RouteStop(
    val number: String,
    val name: String,
    val gpsCoordinates: GpsCoordinates?,
    val node: String,
    val variants: List<VariantLetter>
)
