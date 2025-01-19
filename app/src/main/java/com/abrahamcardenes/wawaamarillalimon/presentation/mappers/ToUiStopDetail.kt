package com.abrahamcardenes.wawaamarillalimon.presentation.mappers

import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail

fun List<BusStop>.toUiStopDetail(): List<UiBusStopDetail> {
    return this.map {
        UiBusStopDetail(
            addressName = it.addressName,
            stopNumber = it.stopNumber,
            availableBusLines = null,
            isExpanded = false
        )
    }
}