package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels

import com.abrahamcardenes.lpa_domain.models.common.WawaColor

data class TimeUi(
    val time: String,
    val color: WawaColor,
    val variant: String = ""
)
