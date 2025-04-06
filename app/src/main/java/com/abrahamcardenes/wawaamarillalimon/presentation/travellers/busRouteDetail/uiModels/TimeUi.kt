package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.uiModels

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor

data class TimeUi(
    val time: String,
    val color: RGBAColor,
    val variant: String = ""
)