package com.abrahamcardenes.wawaamarillalimon.domain.models.busStops

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber

data class BusStop(
    val addressName: String,
    val stopNumber: BusStopNumber,
    val isSavedInDb: Boolean
)
