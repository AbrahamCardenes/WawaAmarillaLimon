package com.abrahamcardenes.wawaamarillalimon.presentation.favorites

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.presentation.components.lists.BusStopsList
import com.abrahamcardenes.wawaamarillalimon.presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun FavoritesStopsRoot(
    favoritesStopsViewModel: FavoritesStopsViewModel = hiltViewModel<FavoritesStopsViewModel>(),
    modifier: Modifier = Modifier
) {
    val uiState by favoritesStopsViewModel.uiState.collectAsStateWithLifecycle()
    FavoritesStopsScreen(
        uiState = uiState,
        onBusStopClick = { stopNumber ->
            favoritesStopsViewModel.getBusStopDetail(stopNumber)
        },
        onUserInput = favoritesStopsViewModel::updateUserInput,
        onSaveBusStop = favoritesStopsViewModel::deleteBusStop
    )
}

@Composable
private fun FavoritesStopsScreen(
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
fun BusStopsScreenPreview() {
    WawaAmarillaLimonTheme {
        FavoritesStopsScreen(
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
