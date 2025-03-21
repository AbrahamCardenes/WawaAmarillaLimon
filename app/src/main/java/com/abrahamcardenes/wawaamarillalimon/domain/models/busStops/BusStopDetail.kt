package com.abrahamcardenes.wawaamarillalimon.domain.models.busStops

data class BusStopDetail(
    val addressName: String,
    val availableBusLines: List<BusLine>
)
