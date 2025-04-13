package com.abrahamcardenes.lpa_domain.models.staticApp.concessions

import com.abrahamcardenes.lpa_domain.models.core.RGBAColor

data class ConcessionDetails(
    val name: String,
    val commercial: String,
    val color: RGBAColor
)
