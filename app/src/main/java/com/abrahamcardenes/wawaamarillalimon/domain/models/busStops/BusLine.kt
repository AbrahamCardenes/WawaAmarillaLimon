package com.abrahamcardenes.wawaamarillalimon.domain.models.busStops

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusLineNumber

data class BusLine(
    val number: BusLineNumber,
    val arrivalTimeIn: String,
    val destination: String
)
