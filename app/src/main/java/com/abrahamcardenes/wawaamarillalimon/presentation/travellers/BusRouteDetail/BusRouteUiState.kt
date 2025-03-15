package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.BusRouteDetail

import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.Variants

data class BusRouteUiState(
    val isLoading: Boolean = true,
    val busRoute: BusRoute? = null,
    val selectedVariant: Variants? = null,
    val selectedIndex: Int = 0
)
