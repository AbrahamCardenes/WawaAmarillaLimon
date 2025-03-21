package com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor

data class ConcessionDetails(
    val name: String,
    val commercial: String,
    val color: RGBAColor
)