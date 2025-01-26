package com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.mappers

import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail

fun UiBusStopDetail.toBusStop(): BusStop = BusStop(
    addressName = this.addressName,
    stopNumber = this.stopNumber,
    isSavedInDb = this.isFavorite
)
