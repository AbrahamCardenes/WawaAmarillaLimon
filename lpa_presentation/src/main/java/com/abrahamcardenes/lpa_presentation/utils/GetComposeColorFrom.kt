package com.abrahamcardenes.lpa_presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import com.abrahamcardenes.lpa_domain.models.common.WawaColor

@Composable
fun getComposeColorFromHexHtml(hexColor: String): Color {
    val dynamicColor = Color(hexColor.toColorInt())
    return dynamicColor
}

@Composable
fun getComposeColorFromRGBAColor(wawaColor: WawaColor): Color {
    val dynamicColor = Color(
        red = wawaColor.red,
        green = wawaColor.green,
        blue = wawaColor.blue
    )
    return dynamicColor
}
