package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromHexHtml
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun AvailableRoutes(routes: List<RoutePaths>, selectedRoute: RoutePaths? = null, modifier: Modifier = Modifier) {
    // TODO: remove aux variable, maybe put color transition in line 69
    var expanded by remember { mutableStateOf(false) }
    var selectedRouteAux by remember {
        mutableStateOf(selectedRoute)
    }
    var text by remember {
        mutableStateOf(selectedRoute?.notes ?: "Selecciona tu ruta")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable {
                expanded = true
            }
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selectedRouteAux != null) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(getComposeColorFromHexHtml(selectedRouteAux!!.hexColor).copy(alpha = 0.75f))
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.animateContentSize()
                )
            }

            Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = null)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            routes.forEach {
                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(getComposeColorFromHexHtml(it.hexColor).copy(alpha = 0.75f))
                            )
                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = it.notes,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    },
                    onClick = {
                        expanded = false
                        selectedRouteAux = it
                        text = it.notes
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AvailablePathsPreview() {
    WawaAmarillaLimonTheme {
        AvailableRoutes(
            routes = listOf(
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
