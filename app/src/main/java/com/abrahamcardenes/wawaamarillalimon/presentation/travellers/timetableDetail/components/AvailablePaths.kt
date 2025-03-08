package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromHexHtml
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun AvailablePaths(paths: List<RoutePaths>, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        paths.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(getComposeColorFromHexHtml(it.hexColor).copy(alpha = 0.75f))
                )
                Text(
                    it.notes,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
fun AvailablePathsPreview() {
    WawaAmarillaLimonTheme {
        AvailablePaths(
            paths = listOf(
                RoutePaths(
                    type = "A",
                    hexColor = "#009ee0",
                    notes = "Por Tanatorio"
                ),
                RoutePaths(
                    type = "A",
                    hexColor = "#009036",
                    notes = "Por las Majadillas"
                )
            )
        )
    }
}
