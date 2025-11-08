package com.abrahamcardenes.lpa_domain.valueObjects

import com.abrahamcardenes.lpa_domain.models.core.RGBAColor

typealias RgbString = String

fun RgbString.toRgba(): RGBAColor {
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

fun RGBAColor.toRgbString(): RgbString = "rgb(${this.red}, ${this.green}, ${this.blue})"
