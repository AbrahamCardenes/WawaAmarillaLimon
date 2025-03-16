package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.Variants
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.GpsCoordinates
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.AvailableRoutes
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.BusRouteTopAppBar
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.ConcessionNodesTabRow
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.StopsPager
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme
import kotlinx.coroutines.launch

@Composable
fun BusRouteScreen(
    busNumber: Int,
    hexColorString: String,
    busRouteViewModel: BusRouteViewModel = hiltViewModel<BusRouteViewModel>(),
    onNavigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        busRouteViewModel.getTimetable(busIdNumber = busNumber)
    }

    val busRouteUiState by busRouteViewModel.uiState.collectAsStateWithLifecycle()
    val availableGoRouteStops by busRouteViewModel.availableRouteStops.collectAsStateWithLifecycle()
    val availableBackRouteStops by busRouteViewModel.availableBackRouteStops.collectAsStateWithLifecycle()

    BusRouteUi(
        busNumber = busNumber,
        hexColorString = hexColorString,
        uiState = busRouteUiState,
        availableGoRouteStops = availableGoRouteStops,
        availableBackRouteStops = availableBackRouteStops,
        onNavigateBack = onNavigateBack,
        onRouteSelection = busRouteViewModel::onRouteSelection,
        onTabSelection = busRouteViewModel::onIndexSelection
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BusRouteUi(
    busNumber: Int,
    hexColorString: String,
    uiState: BusRouteUiState,
    availableGoRouteStops: List<RouteStop>,
    availableBackRouteStops: List<RouteStop>,
    onNavigateBack: () -> Unit,
    onRouteSelection: (Variants) -> Unit,
    onTabSelection: (Int) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onTabSelection(page)
        }
    }

    val busRoute = uiState.busRoute
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val activeVariant = remember(
        uiState.selectedIndex,
        uiState.busRoute
    ) {
        if (uiState.selectedIndex == 0) {
            uiState.busRoute?.variantsGo
        } else {
            uiState.busRoute?.variantsBack
        }
    }

    AnimatedContent(
        targetState = uiState.isLoading,
        label = "animation-loading"
    ) { isLoading ->
        if (isLoading) {
            LoadingCircles(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        } else {
            Scaffold(
                topBar = {
                    BusRouteTopAppBar(
                        busNumber = busNumber,
                        hexColorString = hexColorString,
                        title = busRoute!!.name,
                        onNavigateBack = onNavigateBack,
                        scrollBehavior = scrollBehavior
                    )
                },
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
            ) { innerpadding ->
                Column(modifier = Modifier.padding(innerpadding)) {
                    ConcessionNodesTabRow(
                        tabSelected = pagerState.currentPage,
                        nodes = busRoute!!.nodes,
                        onTabClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(it)
                            }
                            onTabSelection(it)
                        },
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    AvailableRoutes(
                        routes = activeVariant,
                        selectedVariant = uiState.selectedVariant,
                        onRouteSelection = onRouteSelection
                    )

                    StopsPager(
                        availableGoRouteStops = availableGoRouteStops,
                        availableBackRouteStops = availableBackRouteStops,
                        pagerState = pagerState,
                        selectedIndex = pagerState.currentPage
                    )
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun TimetablePreview() {
    WawaAmarillaLimonTheme {
        BusRouteUi(
            busNumber = 10,
            hexColorString = "#FFFFFF",
            uiState = BusRouteUiState(
                isLoading = false,
                busRoute = BusRoute(
                    line = "13",
                    name = "Mercado de Vegueta - Tres Palmas",
                    color = RGBAColor(
                        red = 185,
                        green = 102,
                        blue = 161,
                        alpha = 1
                    ),
                    nodes = listOf("Mercado de Vegueta", "Tres Palmas"),
                    variantsGo = listOf(
                        Variants(
                            type = "A",
                            name = "Mercado de Vegueta - Tres Palmas",
                            color = RGBAColor(
                                red = 185,
                                green = 102,
                                blue = 161,
                                alpha = 1
                            )
                        )
                    ),
                    variantsBack = listOf(
                        Variants(
                            type = "B",
                            name = "Tres Palmas - Mercado de Vegueta",
                            color = RGBAColor(
                                red = 185,
                                green = 102,
                                blue = 161,
                                alpha = 1
                            )
                        )
                    ),
                    stops = listOf(
                        RouteStop(
                            number = "993",
                            name = "Mercado de Vegueta",
                            gpsCoordinates = GpsCoordinates(
                                longitude = -15.41300107,
                                latitude = 28.10265634
                            ),
                            node = "Mercado de Vegueta",
                            variants = listOf("A")
                        ),
                        RouteStop(
                            number = "936",
                            name = "Tres Palmas",
                            gpsCoordinates = GpsCoordinates(
                                latitude = 28.06985503,
                                longitude = -15.42283358
                            ),
                            node = "Mercado de Vegueta",
                            variants = listOf("A")
                        ),
                        RouteStop(
                            number = "936",
                            name = "Tres Palmas",
                            gpsCoordinates = GpsCoordinates(
                                latitude = 28.06985503,
                                longitude = -15.42283358
                            ),
                            node = "Tres Palmas",
                            variants = listOf("B")
                        ),
                        RouteStop(
                            number = "993",
                            name = "Mercado de Vegueta",
                            gpsCoordinates = GpsCoordinates(
                                latitude = 28.10265634,
                                longitude = -15.41300107
                            ),
                            node = "Tres Palmas",
                            variants = listOf("B")
                        )
                    )
                ),
                selectedVariant = null
            ),
            onNavigateBack = {},
            onRouteSelection = {},
            onTabSelection = {},
            availableGoRouteStops = emptyList(),
            availableBackRouteStops = emptyList()
        )
    }
}
