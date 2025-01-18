package com.abrahamcardenes.wawaamarillalimon.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.presentation.components.BusStopCard
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BusStopsScreenRoot(
    busStopsViewModel: BusStopsViewModel = hiltViewModel<BusStopsViewModel>(),
    modifier: Modifier = Modifier
) {
    val uiState = busStopsViewModel.uiState.collectAsStateWithLifecycle()
    BusStopsScreen(
        uiState = uiState.value,
        onBusStopClick = { stopNumber ->
            busStopsViewModel.getBusStopDetail(stopNumber)
        },
        modifier = modifier
    )

}

@Composable
private fun BusStopsScreen(
    uiState: BusStopsUiState,
    onBusStopClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items(items = uiState.busStops, key = { it.stopNumber }) {
            BusStopCard(
                busStop = it,
                onClick = {
                    onBusStopClick(it.stopNumber)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize()
            )
        }
    }
}


@Composable()
@PreviewLightDark
fun BusStopsScreenPreview() {
    WawaAmarillaLimonTheme {
        BusStopsScreen(
            uiState = BusStopsUiState().copy(
                busStops = listOf(
                    UiBusStopDetail(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        availableBusLines = emptyList(),
                        isExpanded = false
                    )
                ),
            ),
            onBusStopClick = {}
        )
    }
}
