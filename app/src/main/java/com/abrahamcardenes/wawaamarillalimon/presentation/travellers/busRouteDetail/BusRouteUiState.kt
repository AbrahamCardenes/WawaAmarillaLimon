package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.Variants

data class BusRouteUiState(
    val isLoading: Boolean = true,
    val busRoute: BusRoute? = null,
    val selectedVariant: Variants? = null,
    val selectedIndex: Int = 0,
    val showDialog: Boolean = false
)
