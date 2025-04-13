package com.abrahamcardenes.lpa_presentation.favorites

import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail

data class FavoritesUiState(
    val busStops: List<UiBusStopDetail> = emptyList(),
    val userInput: String = "",
    val isLoading: Boolean = true,
    val currentExpandedBusStop: UiBusStopDetail? = null
) {
    fun keepCurrentExpandedStatus(): FavoritesUiState {
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
