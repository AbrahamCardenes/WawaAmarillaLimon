package com.abrahamcardenes.wawaamarillalimon.fakes

import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail

fun fakeBusStopDetail(): BusStopDetail = BusStopDetail(
    addressName = "Pº SAN JOSÉ (IGLESIA SAN JOSÉ)",
    availableBusLines = listOf(
        BusLine(
            number = 13,
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

fun fakeListUiBusStopDetail(
    isFirstFavorite: Boolean = false,
    isExpanded: Boolean = false,
    lines: List<BusLine>? = null
): List<UiBusStopDetail> = listOf(
    UiBusStopDetail(
        addressName = "TEATRO",
        stopNumber = 1,
        isFavorite = isFirstFavorite,
        isExpanded = false,
        availableBusLines = null
    ),
    UiBusStopDetail(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isFavorite = false,
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

fun fakeListUiBusStopDetailOffline(
    isFirstFavorite: Boolean = false,
    isExpanded: Boolean = false,
    lines: List<BusLine>? = null
): List<UiBusStopDetail> = listOf(
    UiBusStopDetail(
        addressName = "TEATRO",
        stopNumber = 1,
        isFavorite = true,
        isExpanded = false,
        availableBusLines = null
    ),
    UiBusStopDetail(
        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
        stopNumber = 79,
        isFavorite = true,
        isExpanded = isExpanded,
        availableBusLines = lines
    ),
    UiBusStopDetail(
        addressName = "C / FRANCISCO GOURIÉ, 103",
        stopNumber = 2,
        isFavorite = true,
        isExpanded = false,
        availableBusLines = null
    )
)
