package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

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
    val availableRouteStops by busRouteViewModel.availableRouteStops.collectAsStateWithLifecycle()

    BusRouteUi(
        busNumber = busNumber,
        hexColorString = hexColorString,
        uiState = busRouteUiState,
        availableRouteStops = availableRouteStops,
        onNavigateBack = onNavigateBack,
        onRouteSelection = busRouteViewModel::onRouteSelection,
        onTabSelection = busRouteViewModel::onIndexSelection
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BusRouteUi(
    busNumber: Int,
    hexColorString: String,
    uiState: BusRouteUiState,
    availableRouteStops: List<RouteStop>,
    onNavigateBack: () -> Unit,
    onRouteSelection: (Variants) -> Unit,
    onTabSelection: (Int) -> Unit
) {
    val busRoute = uiState.busRoute
    val scrollState = rememberLazyListState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val tabSelected = uiState.selectedIndex

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
                LazyColumn(
                    state = scrollState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerpadding)
                ) {
                    stickyHeader {
                        ConcessionNodesTabRow(
                            tabSelected = tabSelected,
                            nodes = busRoute!!.nodes,
                            onTabClick = onTabSelection,
                            modifier = Modifier.zIndex(1f)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        // TODO: Put this in viewModel
                        val routes = if (tabSelected == 0) {
                            busRoute!!.variantsGo.map { it }
                        } else {
                            busRoute!!.variantsBack.map { it }
                        }

                        if (routes.size > 1) {
                            AvailableRoutes(
                                routes = routes,
                                selectedVariant = uiState.selectedVariant,
                                onRouteSelection = onRouteSelection
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }

                    items(availableRouteStops) { routeStop ->
                        Card(
                            shape = RectangleShape,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = routeStop.name,
                                style = MaterialTheme.typography.bodyLarge,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .padding(vertical = 12.dp, horizontal = 16.dp)
                                    .fillMaxWidth()
                            )
                        }
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
fun TimetablePreview() {
    WawaAmarillaLimonTheme {
        BusRouteUi(
            busNumber = 10,
            hexColorString = "#FFFFF",
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
            availableRouteStops = emptyList()
        )
    }
}
