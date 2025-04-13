package com.abrahamcardenes.wawaamarillalimon.presentation.busesInfo.busRouteDetail.uiModels

import com.abrahamcardenes.lpa_domain.models.core.RGBAColor

data class TimeUi(
    val time: String,
    val color: RGBAColor,
    val variant: String = ""
)
