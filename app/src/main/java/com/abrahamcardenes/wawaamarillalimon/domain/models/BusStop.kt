package com.abrahamcardenes.wawaamarillalimon.domain.models

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber

data class BusStop(
    val addressName: String,
    val stopNumber: BusStopNumber
)
