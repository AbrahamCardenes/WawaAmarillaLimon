package com.abrahamcardenes.lpa_domain.models.common

import com.abrahamcardenes.lpa_domain.valueObjects.RgbString

data class RGBAColor(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Float
) {

    companion object {
        fun buildRgbaColorFrom(rgbString: RgbString): RGBAColor {
            val noPrefixAndSuffix = if (rgbString.contains("rgba")) {
                rgbString.removePrefix("rgba(").removeSuffix(")")
            } else {
                rgbString.removePrefix("rgb(").removeSuffix(")")
            }

            val colors = noPrefixAndSuffix.split(",").map { it.trim() }

            return RGBAColor(
                red = colors[0].toInt(),
                green = colors[1].toInt(),
                blue = colors[2].toInt(),
                alpha = if (colors.size == 4) colors[3].toFloat() else 1f
            )
        }
    }

    fun toRgbString(): RgbString = "rgb(${this.red}, ${this.green}, ${this.blue})"
}
