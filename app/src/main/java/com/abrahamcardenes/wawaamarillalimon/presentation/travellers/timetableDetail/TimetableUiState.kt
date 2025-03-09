package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail

import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths

data class TimetableUiState(
    val isLoading: Boolean = true,
    val timetableInfo: BusTimetables? = null,
    val selectedRoute: RoutePaths? = null,
    val selectedIndex: Int = 0
)
