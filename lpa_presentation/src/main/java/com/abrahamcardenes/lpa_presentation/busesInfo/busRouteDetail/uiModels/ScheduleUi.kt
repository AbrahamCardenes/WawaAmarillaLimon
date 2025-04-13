package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels

data class ScheduleUi(
    val node: String,
    val typology: String,
    val time: List<TimeUi>
)
