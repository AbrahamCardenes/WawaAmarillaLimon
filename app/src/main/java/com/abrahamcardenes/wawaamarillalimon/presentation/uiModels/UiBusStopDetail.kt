package com.abrahamcardenes.wawaamarillalimon.presentation.uiModels

import com.abrahamcardenes.wawaamarillalimon.domain.models.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.BusStopNumber

data class UiBusStopDetail(
    val stopNumber: BusStopNumber,
    val addressName: String,
    val availableBusLines: List<BusLine>? = null,
    val isExpanded: Boolean,
    val isFavorite: Boolean
)
