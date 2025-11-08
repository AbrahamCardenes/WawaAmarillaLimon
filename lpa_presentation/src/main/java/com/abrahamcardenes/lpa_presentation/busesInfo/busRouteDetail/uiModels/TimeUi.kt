package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels

import com.abrahamcardenes.lpa_domain.models.common.RGBAColor

data class TimeUi(
    val time: String,
    val color: RGBAColor,
    val variant: String = ""
)
