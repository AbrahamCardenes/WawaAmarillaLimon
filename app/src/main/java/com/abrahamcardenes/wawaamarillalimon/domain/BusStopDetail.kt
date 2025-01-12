package com.abrahamcardenes.wawaamarillalimon.domain

data class BusStopDetail(
    val addressName: String,
    val availableBusLines: List<BusLine>
)
