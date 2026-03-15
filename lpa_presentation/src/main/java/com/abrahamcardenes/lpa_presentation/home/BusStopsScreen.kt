package com.abrahamcardenes.lpa_presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_presentation.home.components.BusStopsTabs
import com.abrahamcardenes.lpa_presentation.home.components.OnlineBusStops
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import kotlinx.coroutines.launch

@Composable
fun BusStopsScreenRoot(busStopsViewModel: BusStopsViewModel = hiltViewModel<BusStopsViewModel>(), modifier: Modifier = Modifier) {
    val uiState by busStopsViewModel.uiState.collectAsStateWithLifecycle()

    BusStosScreenWithTabs(
        uiState = uiState,
        busStopsViewModel::onTabClick,
        onBusStopClick = { stopNumber ->
            busStopsViewModel.getBusStopDetail(stopNumber)
        },
        onUserInput = busStopsViewModel::updateUserInput,
        onSaveBusStop = busStopsViewModel::saveOrDeleteBusStop,
        refreshBusStops = busStopsViewModel::getBusStops,
        modifier = modifier
    )
}

@Composable
private fun BusStosScreenWithTabs(
    uiState: BusStopsUiState,
    onTabClick: (BusStopTabs) -> Unit,
    onBusStopClick: (Int) -> Unit,
    onUserInput: (String) -> Unit,
    onSaveBusStop: (UiBusStopDetail) -> Unit,
    refreshBusStops: () -> Unit,
    modifier: Modifier = Modifier
) {
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
        BusStopsTabs(
            currentPage = pagerState.currentPage,
            selectedTab = uiState.selectedTab.index,
            onAllTab = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(BusStopTabs.All.index)
                }
                onTabClick(BusStopTabs.All)
            },
            onFavoritesTab = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(BusStopTabs.Favorites.index)
                }
                onTabClick(BusStopTabs.Favorites)
            }
        )
        HorizontalPager(
            state = pagerState
        ) {
            if (pagerState.currentPage == BusStopTabs.All.index) {
                OnlineBusStops(
                    uiState = uiState,
                    onBusStopClick = onBusStopClick,
                    onUserInput = onUserInput,
                    onSaveBusStop = onSaveBusStop,
                    refreshBusStops = refreshBusStops,
                    errorMessage = uiState.errorMessage,
                    modifier = modifier
                )
            }

            if (pagerState.currentPage == BusStopTabs.Favorites.index) {
                Text("Favorites")
            }
        }
    }
}
