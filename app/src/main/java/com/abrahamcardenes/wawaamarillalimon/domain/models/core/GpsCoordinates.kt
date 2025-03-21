package com.abrahamcardenes.wawaamarillalimon.domain.models.core

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.Latitude
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.Longitude

data class GpsCoordinates(
    val longitude: Longitude,
    val latitude: Latitude
)
