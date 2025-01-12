package com.abrahamcardenes.wawaamarillalimon.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.domain.BusStop
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BusStopsScreenRoot(
    busStopsViewModel: BusStopsViewModel = hiltViewModel<BusStopsViewModel>(),
    modifier: Modifier = Modifier
) {
    val uiState = busStopsViewModel.uiState.collectAsStateWithLifecycle()
    BusStopsScreen(uiState = uiState.value, modifier = modifier)

}

@Composable
private fun BusStopsScreen(uiState: BusStopsUiState, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(uiState.busStops) {
            Text("Bus stop: ${it.addressName}")
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
                    BusStop(addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)", stopNumber = 79)
                )
            )
        )
    }
}