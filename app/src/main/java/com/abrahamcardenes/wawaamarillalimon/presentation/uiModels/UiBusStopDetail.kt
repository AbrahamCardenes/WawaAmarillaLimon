package com.abrahamcardenes.wawaamarillalimon.presentation.uiModels

import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber

data class UiBusStopDetail(
    val stopNumber: BusStopNumber,
    val addressName: String,
    val availableBusLines: List<BusLine>? = null,
    val isExpanded: Boolean,
    val isFavorite: Boolean
)
