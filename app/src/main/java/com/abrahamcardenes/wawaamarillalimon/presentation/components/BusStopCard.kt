package com.abrahamcardenes.wawaamarillalimon.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusLine
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BusStopCard(busStop: UiBusStopDetail, onClick: () -> Unit, onIconClick: (UiBusStopDetail) -> Unit, modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            },
        colors =
        CardDefaults
            .cardColors()
    ) {
        Column(
            modifier =
            Modifier
                .wrapContentSize()
                .padding(12.dp)
        ) {
            Row(
                horizontalArrangement =
                Arrangement.spacedBy(
                    space = 6.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement =
                    Arrangement.spacedBy(
                        space = 6.dp,
                        alignment = Alignment.Start
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier =
                    Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = busStop.stopNumber.toString() + " - ",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(text = busStop.addressName, style = MaterialTheme.typography.bodyLarge)
                }

                IconButton(onClick = {
                    onIconClick(busStop)
                }, modifier = Modifier) {
                    Crossfade(busStop.isFavorite, label = "") { isFavotite ->
                        val favoriteIcon = if (isFavotite) {
                            Icons.Outlined.Favorite
                        } else {
                            Icons.Outlined.FavoriteBorder
                        }
                        val tint = if (isFavotite) Color.Red else Color.Black
                        Icon(
                            imageVector = favoriteIcon,
                            contentDescription = null,
                            tint = tint
                        )
                    }
                }
            }

            AnimatedContent(busStop.isExpanded, label = "") {
                if (it) {
                    AnimatedContent(
                        busStop.availableBusLines.isNullOrEmpty(),
                        label = "available-buses-content"
                    ) { isEmpty ->
                        if (isEmpty) {
                            Text(
                                text = stringResource(R.string.no_buses_available),
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        } else {
                            Column {
                                Spacer(modifier = Modifier.height(12.dp))
                                busStop.availableBusLines?.forEach {
                                    Box(
                                        modifier =
                                        Modifier
                                            .fillMaxWidth()
                                            .border(
                                                width = 1.5.dp,
                                                color = MaterialTheme.colorScheme.outline,
                                                shape = MaterialTheme.shapes.medium
                                            )
                                            .padding(12.dp)
                                    ) {
                                        Column {
                                            Text("Línea: ${it.number}")
                                            Text("Destino: ${it.destination}")
                                            Text("Llegada: ${it.arrivalTimeIn}")
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewBusStopCard() {
    WawaAmarillaLimonTheme {
        var busStop by remember {
            mutableStateOf(
                UiBusStopDetail(
                    addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                    stopNumber = 79,
                    availableBusLines =
                    listOf(
                        BusLine(number = 13, arrivalTimeIn = "10min", destination = "TRES PALMAS"),
                        BusLine(number = 13, arrivalTimeIn = "20min", destination = "TRES PALMAS"),
                        BusLine(
                            number = 64,
                            arrivalTimeIn = "20min",
                            destination = "HOYA DE LA PLATA"
                        )
                    ),
                    isExpanded = true,
                    isFavorite = true
                )
            )
        }
        BusStopCard(
            busStop = busStop,
            onClick = { busStop = busStop.copy(isExpanded = !busStop.isExpanded) },
            onIconClick = {}
        )
    }
}
