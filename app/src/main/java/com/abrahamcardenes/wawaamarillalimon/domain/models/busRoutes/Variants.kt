package com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes

import com.abrahamcardenes.wawaamarillalimon.domain.valueObjects.RgbStringColor

data class Variants(
    val type: String,
    val name: String,
    val color: RgbStringColor
)
