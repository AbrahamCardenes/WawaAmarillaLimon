package com.abrahamcardenes.wawaamarillalimon.presentation.mappers

import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail

fun List<BusStop>.toUiStopDetail(): List<UiBusStopDetail> = this.map {
    UiBusStopDetail(
        addressName = it.addressName,
        stopNumber = it.stopNumber,
        availableBusLines = null,
        isExpanded = false,
        isFavorite = it.isSavedInDb
    )
}
