package com.abrahamcardenes.lpa_presentation.home

sealed class BusStopTabs(val index: Int) {
    data class Metadata(val totalTabs: Int = 2) : BusStopTabs(index = -1)
    data object All : BusStopTabs(index = 0)
    data object Favorites : BusStopTabs(index = 1)
}
