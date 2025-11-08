package com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes

import com.abrahamcardenes.lpa_domain.models.common.WawaColor

data class BusSchedule(
    val node: String,
    val typology: String,
    val time: String,
    val color: WawaColor,
    val variantLetter: String? = null
)
