package com.abrahamcardenes.wawaamarillalimon.domain

typealias BusNumber = Int

data class BusLine(
    val number: BusNumber,
    val arrivalTimeIn: String,
    val destination: String
)
