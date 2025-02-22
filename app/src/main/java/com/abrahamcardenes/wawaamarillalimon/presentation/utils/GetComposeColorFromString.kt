package com.abrahamcardenes.wawaamarillalimon.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getComposeColorFromHexHtml(hexColor: String): Color {
    val dynamicColor = Color(android.graphics.Color.parseColor(hexColor))
    return dynamicColor
}
