package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_domain.models.common.GpsCoordinates
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme

@Composable
fun AvailableStopsByVariant(availableRouteStops: List<RouteStop>, modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = modifier
    ) {
        items(items = availableRouteStops, key = { availableRouteStops -> availableRouteStops.number }) { routeStop ->
            Card(
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .animateItem()
            ) {
                Text(
                    text = routeStop.number + " - " + routeStop.name,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                )
            }
            HorizontalDivider()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AvailableStopsByVariantPreview() {
    val mercadoVegueta = "Mercado de Vegueta"
    val tresPalmas = "Tres Palmas"
    WawaAmarillaLimonTheme {
        AvailableStopsByVariant(
            availableRouteStops = listOf(
                RouteStop(
                    number = "993",
                    name = mercadoVegueta,
                    gpsCoordinates = GpsCoordinates(
                        longitude = -15.41300107,
                        latitude = 28.10265634
                    ),
                    node = mercadoVegueta,
                    variants = listOf("A")
                ),
                RouteStop(
                    number = "936",
                    name = tresPalmas,
                    gpsCoordinates = GpsCoordinates(
                        latitude = 28.06985503,
                        longitude = -15.42283358
                    ),
                    node = mercadoVegueta,
                    variants = listOf("A")
                ),
                RouteStop(
                    number = "936",
                    name = tresPalmas,
                    gpsCoordinates = GpsCoordinates(
                        latitude = 28.06985503,
                        longitude = -15.42283358
                    ),
                    node = tresPalmas,
                    variants = listOf("B")
                ),
                RouteStop(
                    number = "993",
                    name = mercadoVegueta,
                    gpsCoordinates = GpsCoordinates(
                        latitude = 28.10265634,
                        longitude = -15.41300107
                    ),
                    node = tresPalmas,
                    variants = listOf("B")
                )
            )
        )
    }
}
