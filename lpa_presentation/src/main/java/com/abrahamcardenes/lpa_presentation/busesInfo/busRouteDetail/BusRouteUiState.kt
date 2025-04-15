package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail

import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants

data class BusRouteUiState(
    val state: BusRouteState = BusRouteState.Loading,
    val busRoute: BusRoute? = null,
    val selectedVariant: Variants? = null,
    val selectedIndex: Int = 0,
    val showDialog: Boolean = false,
    val errorMessage: Int = -1
)
