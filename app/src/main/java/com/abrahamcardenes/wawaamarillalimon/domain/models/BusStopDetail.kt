package com.abrahamcardenes.wawaamarillalimon.domain.models

data class BusStopDetail(
    val addressName: String,
    val availableBusLines: List<BusLine>
)
