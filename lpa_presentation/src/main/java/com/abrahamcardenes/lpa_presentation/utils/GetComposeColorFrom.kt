package com.abrahamcardenes.lpa_presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.abrahamcardenes.lpa_domain.models.common.WawaColor

@Composable
fun getComposeColorFromHexHtml(hexColor: String): Color {
    val dynamicColor = Color(android.graphics.Color.parseColor(hexColor))
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
