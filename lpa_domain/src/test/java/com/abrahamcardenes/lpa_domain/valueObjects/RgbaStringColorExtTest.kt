package com.abrahamcardenes.lpa_domain.valueObjects

import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RgbaStringColorExtTest {

    @Test
    fun `Given a RGB string color it should return a RGBColor`() {
        val expected = RGBAColor(
            red = 188,
            green = 228,
            blue = 246,
            alpha = 1
        )
        val rgbString = "rgb(188, 228, 246)"

        assertThat(rgbString.toRgba()).isEqualTo(expected)
    }

    @Test
    fun `Given a RGBA string color it should return a RGBColor`() {
        val expected = RGBAColor(
            red = 0,
            green = 0,
            blue = 0,
            alpha = 0
        )
        val rgbaString = "rgba(0, 0, 0, 0)"

        assertThat(rgbaString.toRgba()).isEqualTo(expected)
    }

    @Test
    fun `Given a RGBColor it should return a Rgba string color`() {
        val expected = "rgb(188, 228, 246)"
        val rgbaString = RGBAColor(
            red = 188,
            green = 228,
            blue = 246,
            alpha = 1
        )

        assertThat(rgbaString.toRgbString()).isEqualTo(expected)
    }
}
