package com.abrahamcardenes.lpa_presentation.uiModels

import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.valueObjects.BusStopNumber
import com.abrahamcardenes.lpa_presentation.utils.removeNonSpacingMarks

data class UiBusStopDetail(
    val stopNumber: BusStopNumber,
    val addressName: String,
    val availableBusLines: List<BusLine>? = null,
    val isExpanded: Boolean,
    val isFavorite: Boolean
)

fun List<UiBusStopDetail>.filterByStopNumberOrAddressName(input: String): List<UiBusStopDetail> = this.filter { busStop ->
    busStop.stopNumber.toString().contains(other = input, ignoreCase = true) || busStop.addressName.removeNonSpacingMarks()
        .contains(
            other = input,
            ignoreCase = true
        )
}
