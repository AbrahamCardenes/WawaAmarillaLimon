package com.abrahamcardenes.lpa_presentation.fakes

import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail

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

fun fakeListBusStopDetail(setSecondToFavorite: Boolean = false): List<BusStop> = listOf(
    BusStop(
        addressName = "TEATRO",
        stopNumber = 1,
        isFavorite = false
    ),
    BusStop(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isFavorite = setSecondToFavorite
    ),
    BusStop(
        addressName = "C / FRANCISCO GOURIÉ, 103",
        stopNumber = 2,
        isFavorite = false
    )
)

fun fakeListBusStopDetailOffline(setSecondFavoriteValue: Boolean = true): List<BusStop> = listOf(
    BusStop(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isFavorite = setSecondFavoriteValue
    )
)

fun fakeListUiBusStopDetail(isSecondFavorite: Boolean = false, isExpanded: Boolean = false, lines: List<BusLine>? = null): List<UiBusStopDetail> = listOf(
    UiBusStopDetail(
        addressName = "TEATRO",
        stopNumber = 1,
        isFavorite = false,
        isExpanded = false,
        availableBusLines = null
    ),
    UiBusStopDetail(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isFavorite = isSecondFavorite,
        isExpanded = isExpanded,
        availableBusLines = lines
    ),
    UiBusStopDetail(
        addressName = "C / FRANCISCO GOURIÉ, 103",
        stopNumber = 2,
        isFavorite = false,
        isExpanded = false,
        availableBusLines = null
    )
)

fun fakeListUiBusStopDetailOffline(setFavorite: Boolean = false, isExpanded: Boolean = false, lines: List<BusLine>? = null): List<UiBusStopDetail> = listOf(
    UiBusStopDetail(
        addressName = "TEATRO",
        stopNumber = 1,
        isFavorite = false,
        isExpanded = false,
        availableBusLines = null
    ),
    UiBusStopDetail(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isFavorite = setFavorite,
        isExpanded = isExpanded,
        availableBusLines = lines
    ),
    UiBusStopDetail(
        addressName = "C / FRANCISCO GOURIÉ, 103",
        stopNumber = 2,
        isFavorite = false,
        isExpanded = false,
        availableBusLines = null
    )
)
