package com.abrahamcardenes.lpa_domain.models.staticApp.concessions

import com.abrahamcardenes.lpa_domain.models.common.RGBAColor

data class ConcessionDetails(
    val name: String,
    val commercial: String,
    val color: RGBAColor
)
