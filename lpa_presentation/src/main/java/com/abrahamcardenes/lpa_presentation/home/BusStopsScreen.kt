package com.abrahamcardenes.lpa_presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.components.textfields.BusTextField
import com.abrahamcardenes.lpa_presentation.components.textfields.BusTextFieldConfig
import com.abrahamcardenes.lpa_presentation.home.components.BusStopsTabs
import com.abrahamcardenes.lpa_presentation.home.components.FavoriteStops
import com.abrahamcardenes.lpa_presentation.home.components.OnlineBusStops
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import kotlinx.coroutines.launch

@Composable
fun BusStopsScreenRoot(busStopsViewModel: BusStopsViewModel = hiltViewModel<BusStopsViewModel>(), modifier: Modifier = Modifier) {
    val onlineBusStopsState by busStopsViewModel.onlineBusStopsState.collectAsStateWithLifecycle()
    val favoriteBusStopsState by busStopsViewModel.favoriteBusStopsUiState.collectAsStateWithLifecycle()

    BusStosScreenWithTabs(
        onlineBusStopsState = onlineBusStopsState,
        favoriteBusStopsState = favoriteBusStopsState,
        onTabClick = busStopsViewModel::onTabClick,
        onBusStopClick = { stopNumber, origin ->
            busStopsViewModel.getBusStopDetail(stopNumber, origin)
        },
        onUserInput = busStopsViewModel::updateUserInput,
        onSaveBusStop = busStopsViewModel::saveOrDeleteBusStop,
        refreshBusStops = busStopsViewModel::getBusStops,
        modifier = modifier
    )
}

@Composable
private fun BusStosScreenWithTabs(
    onlineBusStopsState: BusStopsUiState,
    favoriteBusStopsState: FavoritesUiState,
    onTabClick: (BusStopTabs) -> Unit,
    onBusStopClick: (Int, BusStopOrigin) -> Unit,
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
    println("#### bool selected: ${onlineBusStopsState.selectedTab.index}")
    println("#### bool: ${onlineBusStopsState.selectedTab.index == pagerState.currentPage}")
    Column(modifier = modifier) {
        BusStopsTabs(
            currentPage = pagerState.currentPage,
            selectedTab = onlineBusStopsState.selectedTab.index,
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
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) {
            if (pagerState.currentPage == BusStopTabs.All.index) {
                OnlineBusStops(
                    state = onlineBusStopsState,
                    onBusStopClick = { stopNumber ->
                        onBusStopClick(stopNumber, BusStopOrigin.ONLINE)
                    },
                    onSaveBusStop = onSaveBusStop,
                    refreshBusStops = refreshBusStops,
                    errorMessage = onlineBusStopsState.errorMessage,
                    modifier = modifier
                )
            }

            if (pagerState.currentPage == BusStopTabs.Favorites.index) {
                FavoriteStops(
                    uiState = favoriteBusStopsState,
                    onBusStopClick = { stopNumber ->
                        onBusStopClick(stopNumber, BusStopOrigin.FAVORITES)
                    },
                    onSaveBusStop = onSaveBusStop
                )
            }
        }

        BusTextField(
            busTextFieldConfig = BusTextFieldConfig(
                label = stringResource(R.string.search_bus_stop_textfield),
                value = onlineBusStopsState.userInput
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            onUserInput = { input ->
                onUserInput(input)
            }
        )
    }
}
