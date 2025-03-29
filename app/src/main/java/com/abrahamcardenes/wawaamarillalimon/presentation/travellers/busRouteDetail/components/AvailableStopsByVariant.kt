package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components

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
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.GpsCoordinates
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

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
    WawaAmarillaLimonTheme {
        AvailableStopsByVariant(
            availableRouteStops = listOf(
                RouteStop(
                    number = "993",
                    name = "Mercado de Vegueta",
                    gpsCoordinates = GpsCoordinates(
                        longitude = -15.41300107,
                        latitude = 28.10265634
                    ),
                    node = "Mercado de Vegueta",
                    variants = listOf("A")
                ),
                RouteStop(
                    number = "936",
                    name = "Tres Palmas",
                    gpsCoordinates = GpsCoordinates(
                        latitude = 28.06985503,
                        longitude = -15.42283358
                    ),
                    node = "Mercado de Vegueta",
                    variants = listOf("A")
                ),
                RouteStop(
                    number = "936",
                    name = "Tres Palmas",
                    gpsCoordinates = GpsCoordinates(
                        latitude = 28.06985503,
                        longitude = -15.42283358
                    ),
                    node = "Tres Palmas",
                    variants = listOf("B")
                ),
                RouteStop(
                    number = "993",
                    name = "Mercado de Vegueta",
                    gpsCoordinates = GpsCoordinates(
                        latitude = 28.10265634,
                        longitude = -15.41300107
                    ),
                    node = "Tres Palmas",
                    variants = listOf("B")
                )
            )
        )
    }
}
