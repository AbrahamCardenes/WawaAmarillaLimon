package com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes

import com.abrahamcardenes.lpa_domain.models.common.RGBAColor

data class BusSchedule(
    val node: String,
    val typology: String,
    val time: String,
    val color: RGBAColor,
    val variantLetter: String? = null
)
