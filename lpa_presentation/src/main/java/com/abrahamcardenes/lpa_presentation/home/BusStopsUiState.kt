package com.abrahamcardenes.lpa_presentation.home

import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail

data class BusStopsUiState(
    val busStops: List<UiBusStopDetail> = emptyList(),
    val userInput: String = "",
    val state: BusStopState = BusStopState.Loading,
    val currentExpandedBusStop: UiBusStopDetail? = null,
    val errorMessage: Int = -1
) {
    fun keepCurrentExpandedStatus(): BusStopsUiState {
        val expandedIndex = this.busStops.indexOfFirst { it.stopNumber == this.currentExpandedBusStop?.stopNumber }
        val updatedBusStops = if (expandedIndex >= 0) {
            busStops.toMutableList().apply {
                this[expandedIndex] =
                    this[expandedIndex].copy(
                        isExpanded = true,
                        availableBusLines = currentExpandedBusStop?.availableBusLines
                    )
            }
        } else {
            busStops // No matching bus stop, return original list
        }
        return this.copy(busStops = updatedBusStops)
    }
}
