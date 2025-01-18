package com.abrahamcardenes.wawaamarillalimon.domain.models

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusNumber

data class BusLine(
    val number: BusNumber,
    val arrivalTimeIn: String,
    val destination: String
)