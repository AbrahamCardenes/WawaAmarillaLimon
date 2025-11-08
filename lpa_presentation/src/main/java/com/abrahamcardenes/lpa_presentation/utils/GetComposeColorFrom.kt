package com.abrahamcardenes.lpa_presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.abrahamcardenes.lpa_domain.models.common.RGBAColor

@Composable
fun getComposeColorFromHexHtml(hexColor: String): Color {
    val dynamicColor = Color(android.graphics.Color.parseColor(hexColor))
    return dynamicColor
}

@Composable
fun getComposeColorFromRGBAColor(rgbaColor: RGBAColor): Color {
    val dynamicColor = Color(
        red = rgbaColor.red,
        green = rgbaColor.green,
        blue = rgbaColor.blue
    )
    return dynamicColor
}
