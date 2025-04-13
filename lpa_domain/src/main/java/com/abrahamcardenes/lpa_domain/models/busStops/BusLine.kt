package com.abrahamcardenes.lpa_domain.models.busStops

import com.abrahamcardenes.lpa_domain.valueObjects.BusLineNumber

data class BusLine(
    val number: BusLineNumber,
    val arrivalTimeIn: String,
    val destination: String
)
