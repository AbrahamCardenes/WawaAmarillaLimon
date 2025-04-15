package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail

sealed class BusRouteState() {
    object Loading : BusRouteState()
    object Success : BusRouteState()
    object Error : BusRouteState()
}
