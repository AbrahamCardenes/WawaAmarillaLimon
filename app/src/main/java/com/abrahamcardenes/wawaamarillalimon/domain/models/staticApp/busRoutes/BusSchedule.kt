package com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor

data class BusSchedule(
    val node: String,
    val tipology: String,
    val time: String,
    val color: RGBAColor,
    val variantLetter: String? = null
)
