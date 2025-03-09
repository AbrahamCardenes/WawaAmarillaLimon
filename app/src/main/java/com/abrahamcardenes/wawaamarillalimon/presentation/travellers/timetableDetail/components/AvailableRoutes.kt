package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromHexHtml
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun AvailableRoutes(
    routes: List<RoutePaths>,
    selectedRoute: RoutePaths? = null,
    onRouteSelection: (RoutePaths) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    val backgroundColor = animateColorAsState(
        targetValue = if (selectedRoute == null) Color.White else getComposeColorFromHexHtml(selectedRoute.hexColor),
        animationSpec = tween(250, 0, LinearEasing)
    )

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
            if (selectedRoute != null) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(backgroundColor.value)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = selectedRoute?.notes ?: "Selecciona tu ruta",
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
            routes.forEach { route ->
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
                                    .background(getComposeColorFromHexHtml(route.hexColor).copy(alpha = 0.75f))
                            )
                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = route.notes,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    },
                    onClick = {
                        onRouteSelection(route)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AvailablePathsPreview() {
    var selectedRoute by remember {
        mutableStateOf<RoutePaths?>(null)
    }
    WawaAmarillaLimonTheme {
        AvailableRoutes(
            selectedRoute = selectedRoute,
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
            ),
            onRouteSelection = {
                selectedRoute = it
            }
        )
    }
}
