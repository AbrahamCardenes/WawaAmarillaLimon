package com.abrahamcardenes.wawaamarillalimon.presentation.busesInfo.busRouteDetail.uiModels

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor

data class TimeUi(
    val time: String,
    val color: RGBAColor,
    val variant: String = ""
)
