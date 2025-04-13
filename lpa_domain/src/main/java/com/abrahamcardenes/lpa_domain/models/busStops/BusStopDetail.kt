package com.abrahamcardenes.lpa_domain.models.busStops

data class BusStopDetail(
    val addressName: String,
    val availableBusLines: List<BusLine>
)
