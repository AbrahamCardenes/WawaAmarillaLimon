package com.abrahamcardenes.wawaamarillalimon.fakes

import com.abrahamcardenes.wawaamarillalimon.domain.models.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail

fun fakeBusStopDetail(): BusStopDetail {
    return BusStopDetail(
        addressName = "Pº SAN JOSÉ (IGLESIA SAN JOSÉ)",
        availableBusLines = listOf(
            BusLine(
                number = 13,
                destination = "TRESPALMAS",
                arrivalTimeIn = "15min"
            )
        )
    )
}