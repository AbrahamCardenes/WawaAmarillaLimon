package com.abrahamcardenes.lpa_domain.models.common

import com.abrahamcardenes.lpa_domain.models.common.WawaColor.Companion.buildWawaColorFrom
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class WawaColorTest {
    @Test
    fun `Given a RGB string color it should return a RGBColor`() {
        val expected = WawaColor(
            red = 188,
            green = 228,
            blue = 246,
            alpha = 1f
        )
        val rgbString = "rgb(188, 228, 246)"

        assertThat(buildWawaColorFrom(rgbString)).isEqualTo(expected)
    }

    @Test
    fun `Given a RGBA string color it should return a RGBColor`() {
        val expected = WawaColor(
            red = 0,
            green = 0,
            blue = 0,
            alpha = 0f
        )
        val rgbaString = "rgba(0, 0, 0, 0)"

        assertThat(buildWawaColorFrom(rgbaString)).isEqualTo(expected)
    }

    @Test
    fun `Given a RGBColor it should return a Rgba string color`() {
        val expected = "rgb(188, 228, 246)"
        val rgbaString = WawaColor(
            red = 188,
            green = 228,
            blue = 246,
            alpha = 1f
        )

        assertThat(rgbaString.toRgbString()).isEqualTo(expected)
    }
}
