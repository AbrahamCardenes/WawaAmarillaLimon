package com.abrahamcardenes.lpa_domain.models.core

import com.abrahamcardenes.lpa_domain.valueObjects.Latitude
import com.abrahamcardenes.lpa_domain.valueObjects.Longitude

data class GpsCoordinates(
    val longitude: Longitude,
    val latitude: Latitude
)
