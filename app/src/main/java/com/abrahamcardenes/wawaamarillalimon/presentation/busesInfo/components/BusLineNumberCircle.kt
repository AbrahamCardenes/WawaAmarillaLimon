package com.abrahamcardenes.wawaamarillalimon.presentation.busesInfo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BusLineNumberCircle(dynamicColor: Color, commercialName: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(dynamicColor.copy(alpha = 0.75f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = commercialName,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
@PreviewLightDark
fun BusLineNumberCirclePreview() {
    WawaAmarillaLimonTheme {
        BusLineNumberCircle(
            dynamicColor = Color.White,
            commercialName = "13",
            modifier = Modifier.size(50.dp)
        )
    }
}
