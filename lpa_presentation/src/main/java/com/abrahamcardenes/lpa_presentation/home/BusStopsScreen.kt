package com.abrahamcardenes.lpa_presentation.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.components.errors.CatError
import com.abrahamcardenes.lpa_presentation.components.lists.BusStopsList
import com.abrahamcardenes.lpa_presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import kotlinx.coroutines.launch

@Composable
fun BusStopsScreenRoot(busStopsViewModel: BusStopsViewModel = hiltViewModel<BusStopsViewModel>(), modifier: Modifier = Modifier) {
    val uiState by busStopsViewModel.uiState.collectAsStateWithLifecycle()

    BusStosScreenWithTabs(
        uiState = uiState,
        busStopsViewModel::onTabClick
    )
    /*BusStopsScreen(
        uiState = uiState,
        onBusStopClick = { stopNumber ->
            busStopsViewModel.getBusStopDetail(stopNumber)
        },
        onUserInput = busStopsViewModel::updateUserInput,
        onSaveBusStop = busStopsViewModel::saveOrDeleteBusStop,
        refreshBusStops = busStopsViewModel::getBusStops,
        errorMessage = uiState.errorMessage,
        modifier = modifier
    )*/
}

@Composable
private fun BusStosScreenWithTabs(uiState: BusStopsUiState, onTabClick: (BusStopTabs) -> Unit, modifier: Modifier = Modifier) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {
        BusStopTabs.Metadata().totalTabs
    })

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            if (page == 0) {
                onTabClick(BusStopTabs.All)
            }
            if (page == 1) {
                onTabClick(BusStopTabs.Favorites)
            }
        }
    }

    println("#### bool count: ${pagerState.pageCount}")
    println("#### bool currentPage: ${pagerState.currentPage}")
    println("#### bool selected: ${uiState.selectedTab.index}")
    println("#### bool: ${uiState.selectedTab.index == pagerState.currentPage}")
    Column(modifier = modifier) {
        // break this into pieces.
        PrimaryTabRow(
            selectedTabIndex = pagerState.currentPage
        ) {
            Tab(
                selected = uiState.selectedTab.index == pagerState.currentPage,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(BusStopTabs.All.index)
                    }
                    onTabClick(BusStopTabs.All)
                }
            ) {
                Text(
                    text = stringResource(R.string.stops),
                    style = MaterialTheme.typography.titleMedium
                        .copy(textAlign = TextAlign.Center),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
            Tab(
                selected = uiState.selectedTab.index == pagerState.currentPage,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(BusStopTabs.Favorites.index)
                    }
                    onTabClick(BusStopTabs.Favorites)
                }
            ) {
                Text(
                    text = stringResource(R.string.favorites),
                    style = MaterialTheme.typography.titleMedium
                        .copy(textAlign = TextAlign.Center),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }

        HorizontalPager(
            state = pagerState
        ) {
            if (pagerState.currentPage == BusStopTabs.All.index) {
                Text("All")
            }

            if (pagerState.currentPage == BusStopTabs.Favorites.index) {
                Text("Favorites")
            }
        }
    }
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
