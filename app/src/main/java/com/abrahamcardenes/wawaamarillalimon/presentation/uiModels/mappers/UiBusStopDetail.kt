package com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.mappers

import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail

fun UiBusStopDetail.toBusStop(): BusStop = BusStop(
    addressName = this.addressName,
    stopNumber = this.stopNumber,
    isSavedInDb = this.isFavorite
)
