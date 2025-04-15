package com.abrahamcardenes.lpa_presentation.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_presentation.components.errors.CatError
import com.abrahamcardenes.lpa_presentation.components.lists.BusStopsList
import com.abrahamcardenes.lpa_presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail

@Composable
fun BusStopsScreenRoot(busStopsViewModel: BusStopsViewModel = hiltViewModel<BusStopsViewModel>(), modifier: Modifier = Modifier) {
    val uiState by busStopsViewModel.uiState.collectAsStateWithLifecycle()
    BusStopsScreen(
        uiState = uiState,
        onBusStopClick = { stopNumber ->
            busStopsViewModel.getBusStopDetail(stopNumber)
        },
        onUserInput = busStopsViewModel::updateUserInput,
        onSaveBusStop = busStopsViewModel::saveOrDeleteBusStop,
        refreshBusStops = busStopsViewModel::getBusStops,
        errorMessage = uiState.errorMessage,
        modifier = modifier
    )
}

@Composable
private fun BusStopsScreen(
    uiState: BusStopsUiState,
    onBusStopClick: (Int) -> Unit,
    onUserInput: (String) -> Unit,
    onSaveBusStop: (UiBusStopDetail) -> Unit,
    errorMessage: Int,
    refreshBusStops: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedContent(
        targetState = uiState.state,
        label = "animation-content"
    ) { currentState ->
        when (currentState) {
            BusStopState.Error -> {
                CatError(
                    onClick = {
                        refreshBusStops()
                    },
                    message = stringResource(errorMessage),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize()
                )
            }

            BusStopState.Loading -> {
                LoadingCircles(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            BusStopState.Success -> {
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
}

@Composable()
@PreviewLightDark
fun BusStopsScreenPreview() {
    WawaAmarillaLimonTheme {
        BusStopsScreen(
            uiState =
            BusStopsUiState().copy(
                busStops =
                listOf(
                    UiBusStopDetail(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        availableBusLines = emptyList(),
                        isExpanded = false,
                        isFavorite = false
                    )
                )
            ),
            errorMessage = -1,
            onBusStopClick = {},
            onUserInput = {},
            onSaveBusStop = {},
            refreshBusStops = {}
        )
    }
}
