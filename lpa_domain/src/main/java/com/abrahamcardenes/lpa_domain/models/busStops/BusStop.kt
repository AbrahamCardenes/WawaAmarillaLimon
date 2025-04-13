package com.abrahamcardenes.lpa_domain.models.busStops

import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber

data class BusStop(
    val addressName: String,
    val stopNumber: BusStopNumber,
    val isSavedInDb: Boolean
)
