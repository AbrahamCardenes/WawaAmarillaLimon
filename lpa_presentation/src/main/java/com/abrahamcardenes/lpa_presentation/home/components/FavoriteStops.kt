package com.abrahamcardenes.lpa_presentation.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.components.cat.CatMessage
import com.abrahamcardenes.lpa_presentation.components.lists.BusStopsList
import com.abrahamcardenes.lpa_presentation.home.states.BusStopsUiState
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.lpa_presentation.utils.getRandomEmptyCatMessage

@Composable
fun FavoriteStops(
    uiState: BusStopsUiState,
    onBusStopClick: (Int) -> Unit,
    onSaveBusStop: (UiBusStopDetail) -> Unit,
    modifier: Modifier = Modifier
) {
    val randomMessage by remember {
        mutableIntStateOf(getRandomEmptyCatMessage())
    }
    AnimatedContent(
        targetState = uiState.favoriteBusStops.isEmpty(),
        label = "animation-loading-bus-stops"
    ) { isEmpty ->
        if (isEmpty) {
            CatMessage(
                onClick = {},
                message = stringResource(randomMessage),
                actionMessage = null,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            )
        } else {
            BusStopsList(
                onSaveBusStop = onSaveBusStop,
                onBusStopClick = onBusStopClick,
                busStops = uiState.favoriteBusStops,
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
            BusStopsUiState().copy(
                favoriteBusStops =
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
            onSaveBusStop = {}
        )
    }
}
