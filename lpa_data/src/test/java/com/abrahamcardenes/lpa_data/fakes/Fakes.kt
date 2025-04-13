package com.abrahamcardenes.lpa_data.fakes

import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail

fun fakeBusStopDetail(): BusStopDetail = BusStopDetail(
    addressName = "Pº SAN JOSÉ (IGLESIA SAN JOSÉ)",
    availableBusLines = listOf(
        BusLine(
            number = "13",
            destination = "TRESPALMAS",
            arrivalTimeIn = "15min"
        )
    )
)

