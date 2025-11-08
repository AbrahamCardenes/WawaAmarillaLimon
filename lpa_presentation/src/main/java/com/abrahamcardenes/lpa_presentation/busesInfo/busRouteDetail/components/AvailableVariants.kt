package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components

import androidx.compose.animation.AnimatedVisibility
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
import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.utils.getComposeColorFromRGBAColor

@Composable
fun AvailableRoutes(
    routes: List<Variants>?,
    onRouteSelection: (Variants) -> Unit,
    modifier: Modifier = Modifier,
    selectedVariant: Variants? = null
) {
    var expanded by remember { mutableStateOf(false) }

    val backgroundColor = animateColorAsState(
        targetValue = if (selectedVariant == null) Color.White else getComposeColorFromRGBAColor(selectedVariant.color),
        animationSpec = tween(250, 0, LinearEasing)
    )

    AnimatedVisibility(routes != null && routes.size > 1) {
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
                if (selectedVariant != null) {
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
                        text = selectedVariant?.name ?: "Selecciona tu ruta",
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
                routes!!.forEach { route ->
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
                                        .background(getComposeColorFromRGBAColor(route.color).copy(alpha = 0.75f))
                                )
                                Spacer(modifier = Modifier.width(12.dp))

                                Text(
                                    text = route.name,
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
}

@Composable
@Preview(showBackground = true)
fun AvailablePathsPreview() {
    var selectedRoute by remember {
        mutableStateOf<Variants?>(null)
    }
    WawaAmarillaLimonTheme {
        AvailableRoutes(
            selectedVariant = selectedRoute,
            routes = listOf(
                Variants(
                    type = "A",
                    name = "Mercado de Vegueta - Tres Palmas",
                    color = RGBAColor(
                        red = 185,
                        green = 102,
                        blue = 161,
                        alpha = 1f
                    )
                )
            ),
            onRouteSelection = {
                selectedRoute = it
            }
        )
    }
}
