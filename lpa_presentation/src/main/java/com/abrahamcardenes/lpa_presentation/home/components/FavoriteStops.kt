package com.abrahamcardenes.lpa_presentation.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.components.lists.BusStopsList
import com.abrahamcardenes.lpa_presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.lpa_presentation.favorites.FavoritesUiState
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail

@Composable
fun FavoriteStops(
    uiState: FavoritesUiState,
    onBusStopClick: (Int) -> Unit,
    onUserInput: (String) -> Unit,
    onSaveBusStop: (UiBusStopDetail) -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedContent(
        targetState = uiState.isLoading,
        label = "animation-loading-bus-stops"
    ) { isLoading ->
        if (isLoading) {
            LoadingCircles(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        } else {
            BusStopsList(
                onSaveBusStop = onSaveBusStop,
                onBusStopClick = onBusStopClick,
                onUserInput = onUserInput,
                busStops = uiState.busStops,
                textFieldInput = uiState.userInput,
                modifier = modifier
            )
        }
    }
}

@Composable()
@PreviewLightDark
fun FavoriteStopsPreview() {
    WawaAmarillaLimonTheme {
        FavoriteStops(
            uiState =
            FavoritesUiState().copy(
                busStops =
                mutableListOf(
                    UiBusStopDetail(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        availableBusLines = emptyList(),
                        isExpanded = false,
                        isFavorite = false
                    )
                )
            ),
            onBusStopClick = {},
            onUserInput = {},
            onSaveBusStop = {}
        )
    }
}
