package com.abrahamcardenes.lpa_presentation.favorites

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_presentation.home.components.FavoriteStops

@Composable
fun FavoritesStopsRoot(favoritesStopsViewModel: FavoritesStopsViewModel = hiltViewModel<FavoritesStopsViewModel>()) {
    val uiState by favoritesStopsViewModel.uiState.collectAsStateWithLifecycle()
    FavoriteStops(
        uiState = uiState,
        onBusStopClick = { stopNumber ->
            favoritesStopsViewModel.getBusStopDetail(stopNumber)
        },
        onUserInput = favoritesStopsViewModel::updateUserInput,
        onSaveBusStop = favoritesStopsViewModel::deleteBusStop
    )
}
