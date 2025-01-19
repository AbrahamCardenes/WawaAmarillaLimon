package com.abrahamcardenes.wawaamarillalimon.presentation

import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail

data class BusStopsUiState(
    val busStops: List<UiBusStopDetail> = emptyList(),
)