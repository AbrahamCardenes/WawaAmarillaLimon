package com.abrahamcardenes.lpa_domain.fakes

import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
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

fun fakeListBusStopDetail(setFirstToFavorite: Boolean = false): List<BusStop> = listOf(
    BusStop(
        addressName = "TEATRO",
        stopNumber = 1,
        isSavedInDb = setFirstToFavorite
    ),
    BusStop(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isSavedInDb = false
    ),
    BusStop(
        addressName = "C / FRANCISCO GOURIÉ, 103",
        stopNumber = 2,
        isSavedInDb = false
    )
)

fun fakeListBusStopDetailOffline(setSecondFavoriteValue: Boolean = true): List<BusStop> = listOf(
    BusStop(
        addressName = "TEATRO",
        stopNumber = 1,
        isSavedInDb = true
    ),
    BusStop(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isSavedInDb = setSecondFavoriteValue
    ),
    BusStop(
        addressName = "C / FRANCISCO GOURIÉ, 103",
        stopNumber = 2,
        isSavedInDb = true
    )
)
