package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_domain.models.common.GpsCoordinates
import com.abrahamcardenes.lpa_domain.models.common.WawaColor
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusSchedule
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components.AvailableRoutes
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components.BusRouteTopAppBar
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components.ConcessionNodesTabRow
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components.StopsPager
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels.ScheduleUi
import com.abrahamcardenes.lpa_presentation.components.errors.CatError
import com.abrahamcardenes.lpa_presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import kotlinx.coroutines.launch

@Composable
fun BusRouteScreen(
    busNumber: String,
    wawaColor: WawaColor,
    busRouteViewModel: BusRouteViewModel = hiltViewModel<BusRouteViewModel>(),
    onNavigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        busRouteViewModel.getBusRoute(busIdNumber = busNumber)
    }

    val busRouteUiState by busRouteViewModel.uiState.collectAsStateWithLifecycle()
    val availableGoRouteStops by busRouteViewModel.availableRouteStops.collectAsStateWithLifecycle()
    val availableBackRouteStops by busRouteViewModel.availableBackRouteStops.collectAsStateWithLifecycle()
    val busRouteSchedule by busRouteViewModel.busSchedules.collectAsStateWithLifecycle()

    BusRouteUi(
        commercialLine = busNumber,
        wawaColor = wawaColor,
        uiState = busRouteUiState,
        availableGoRouteStops = availableGoRouteStops,
        availableBackRouteStops = availableBackRouteStops,
        busRouteSchedule = busRouteSchedule,
        onNavigateBack = onNavigateBack,
        onRouteSelection = busRouteViewModel::onRouteSelection,
        onTabSelection = busRouteViewModel::onIndexSelection,
        openOrCloseScheduleDialog = busRouteViewModel::openOrCloseScheduleDialog,
        onRetry = {
            busRouteViewModel.getBusRoute(busIdNumber = busNumber)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BusRouteUi(
    commercialLine: String,
    wawaColor: WawaColor,
    uiState: BusRouteUiState,
    availableGoRouteStops: List<RouteStop>,
    availableBackRouteStops: List<RouteStop>,
    busRouteSchedule: List<ScheduleUi>,
    onNavigateBack: () -> Unit,
    onRouteSelection: (Variants) -> Unit,
    openOrCloseScheduleDialog: () -> Unit,
    onTabSelection: (Int) -> Unit,
    onRetry: () -> Unit
) {
    val busRoute = uiState.busRoute
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {
        busRoute?.nodes?.size ?: 0
    })

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onTabSelection(page)
        }
    }

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
        targetState = uiState.state,
        label = "animation-loading"
    ) { state ->
        when (state) {
            BusRouteState.Error -> {
                CatError(
                    onClick = onRetry,
                    message = stringResource(uiState.errorMessage),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize()
                )
            }

            BusRouteState.Loading -> {
                LoadingCircles(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            BusRouteState.Success -> {
                Scaffold(
                    topBar = {
                        BusRouteTopAppBar(
                            commercial = commercialLine,
                            wawaColor = wawaColor,
                            title = busRoute!!.name,
                            onNavigateBack = onNavigateBack,
                            scrollBehavior = scrollBehavior
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = openOrCloseScheduleDialog
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_schedule),
                                contentDescription = stringResource(
                                    R.string.show_schedule
                                ),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                ) { innerpadding ->
                    SchedulesDialog(
                        showDialog = uiState.showDialog,
                        openOrCloseScheduleDialog = openOrCloseScheduleDialog,
                        busRouteSchedule = busRouteSchedule
                    )
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
}

@Composable
@PreviewLightDark
private fun TimetablePreview() {
    WawaAmarillaLimonTheme {
        val mercadoVeguetaNode = "Mercado de Vegueta"
        val tresPalmasNode = "Tres Palmas"
        BusRouteUi(
            commercialLine = "10",
            wawaColor = WawaColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1f
            ),
            uiState = BusRouteUiState(
                state = BusRouteState.Success,
                busRoute = BusRoute(
                    line = "13",
                    name = "$mercadoVeguetaNode - $tresPalmasNode",
                    color = WawaColor(
                        red = 185,
                        green = 102,
                        blue = 161,
                        alpha = 1f
                    ),
                    nodes = listOf(mercadoVeguetaNode, tresPalmasNode),
                    variantsGo = listOf(
                        Variants(
                            type = "A",
                            name = "$mercadoVeguetaNode - $tresPalmasNode",
                            color = WawaColor(
                                red = 185,
                                green = 102,
                                blue = 161,
                                alpha = 1f
                            )
                        )
                    ),
                    variantsBack = listOf(
                        Variants(
                            type = "B",
                            name = "$tresPalmasNode - $mercadoVeguetaNode",
                            color = WawaColor(
                                red = 185,
                                green = 102,
                                blue = 161,
                                alpha = 1f
                            )
                        )
                    ),
                    stops = listOf(
                        RouteStop(
                            number = "993",
                            name = mercadoVeguetaNode,
                            gpsCoordinates = GpsCoordinates(
                                longitude = -15.41300107,
                                latitude = 28.10265634
                            ),
                            node = mercadoVeguetaNode,
                            variants = listOf("A")
                        ),
                        RouteStop(
                            number = "936",
                            name = tresPalmasNode,
                            gpsCoordinates = GpsCoordinates(
                                latitude = 28.06985503,
                                longitude = -15.42283358
                            ),
                            node = mercadoVeguetaNode,
                            variants = listOf("A")
                        ),
                        RouteStop(
                            number = "936",
                            name = tresPalmasNode,
                            gpsCoordinates = GpsCoordinates(
                                latitude = 28.06985503,
                                longitude = -15.42283358
                            ),
                            node = tresPalmasNode,
                            variants = listOf("B")
                        ),
                        RouteStop(
                            number = "993",
                            name = mercadoVeguetaNode,
                            gpsCoordinates = GpsCoordinates(
                                latitude = 28.10265634,
                                longitude = -15.41300107
                            ),
                            node = tresPalmasNode,
                            variants = listOf("B")
                        )
                    ),
                    schedules = listOf(
                        BusSchedule(
                            node = mercadoVeguetaNode,
                            typology = "De lunes a viernes",
                            time = "06:55",
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            )
                        ),
                        BusSchedule(
                            node = mercadoVeguetaNode,
                            typology = "Sábado",
                            time = "08:05",
                            color = WawaColor(
                                red = 0,
                                green = 0,
                                blue = 0,
                                alpha = 0f
                            )
                        ),
                        BusSchedule(
                            node = mercadoVeguetaNode,
                            typology = "Domingo y festivo",
                            time = "07:50",
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            )
                        ),

                        BusSchedule(
                            node = tresPalmasNode,
                            typology = "De lunes a viernes",
                            time = "06:10",
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            )
                        ),
                        BusSchedule(
                            node = tresPalmasNode,
                            typology = "Sábado",
                            time = "07:10",
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            )
                        ),
                        BusSchedule(
                            node = tresPalmasNode,
                            typology = "Domingo y festivo",
                            time = "08:35",
                            color = WawaColor(
                                red = 0,
                                green = 0,
                                blue = 0,
                                alpha = 0f
                            )
                        )
                    )
                ),
                selectedVariant = null
            ),
            onNavigateBack = {},
            onRouteSelection = {},
            onTabSelection = {},
            availableGoRouteStops = emptyList(),
            availableBackRouteStops = emptyList(),
            busRouteSchedule = emptyList(),
            openOrCloseScheduleDialog = {},
            onRetry = {}
        )
    }
}
