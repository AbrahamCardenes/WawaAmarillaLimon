package com.abrahamcardenes.lpa_presentation.home.states

sealed class BusStopState {
    object Loading : BusStopState()
    object Error : BusStopState()
    object Success : BusStopState()
}
