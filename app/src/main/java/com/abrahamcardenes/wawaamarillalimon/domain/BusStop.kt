package com.abrahamcardenes.wawaamarillalimon.domain

typealias BusStopNumber = Int

data class BusStop(
    val addressName: String,
    val stopNumber: BusStopNumber
)
