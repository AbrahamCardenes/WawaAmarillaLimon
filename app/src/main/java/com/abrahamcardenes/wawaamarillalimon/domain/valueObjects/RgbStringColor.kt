package com.abrahamcardenes.wawaamarillalimon.domain.valueObjects

import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor

typealias RgbaStringColor = String

fun RgbaStringColor.toRGBColor(): RGBAColor {
    val noPrefixAndSuffix = if (this.contains("rgba")) {
        this.removePrefix("rgba(").removeSuffix(")")
    } else {
        this.removePrefix("rgb(").removeSuffix(")")
    }

    val colors = noPrefixAndSuffix.split(",").map { it.trim() }

    return RGBAColor(
        red = colors[0].toInt(),
        green = colors[1].toInt(),
        blue = colors[2].toInt(),
        alpha = if (colors.size == 4) colors[3].toInt() else 1
    )
}
