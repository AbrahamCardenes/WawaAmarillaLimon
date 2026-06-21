package com.abrahamcardenes.lpa_presentation.home

sealed class BusStopTabs(val index: Int) {
    data object All : BusStopTabs(index = 0)
    data object Favorites : BusStopTabs(index = 1)

    companion object {
        val entries: List<BusStopTabs> by lazy { listOf(All, Favorites) }
    }
}
