package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.GpsCoordinates
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.BusSchedule
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.wawaamarillalimon.presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.AvailableRoutes
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.BusRouteTopAppBar
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.ConcessionNodesTabRow
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail.components.StopsPager
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromRGBAColor
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme
import kotlinx.coroutines.launch

@Composable
fun BusRouteScreen(
    busNumber: String,
    rgbaColor: RGBAColor,
    busRouteViewModel: BusRouteViewModel = hiltViewModel<BusRouteViewModel>(),
    onNavigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        busRouteViewModel.getBusRoute(busIdNumber = busNumber)
    }

    val busRouteUiState by busRouteViewModel.uiState.collectAsStateWithLifecycle()
    val availableGoRouteStops by busRouteViewModel.availableRouteStops.collectAsStateWithLifecycle()
    val availableBackRouteStops by busRouteViewModel.availableBackRouteStops.collectAsStateWithLifecycle()

    BusRouteUi(
        commercialLine = busNumber,
        rgbaColor = rgbaColor,
        uiState = busRouteUiState,
        availableGoRouteStops = availableGoRouteStops,
        availableBackRouteStops = availableBackRouteStops,
        onNavigateBack = onNavigateBack,
        onRouteSelection = busRouteViewModel::onRouteSelection,
        onTabSelection = busRouteViewModel::onIndexSelection,
        openScheduleDialog = busRouteViewModel::openScheduleDialog
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BusRouteUi(
    commercialLine: String,
    rgbaColor: RGBAColor,
    uiState: BusRouteUiState,
    availableGoRouteStops: List<RouteStop>,
    availableBackRouteStops: List<RouteStop>,
    onNavigateBack: () -> Unit,
    onRouteSelection: (Variants) -> Unit,
    openScheduleDialog: () -> Unit,
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
                        commercial = commercialLine,
                        rgbaColor = rgbaColor,
                        title = busRoute!!.name,
                        onNavigateBack = onNavigateBack,
                        scrollBehavior = scrollBehavior
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = openScheduleDialog
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
                Column(modifier = Modifier.padding(innerpadding)) {
                    Dialog(onDismissRequest = { }) {
                        Card(
                            modifier = Modifier
                                .heightIn(max = 500.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = uiState.selectedVariant.name,
                                    style = MaterialTheme.typography.headlineMedium,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = "Lunes a viernes:",
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    textAlign = TextAlign.Start
                                )

                                FlowRow(
                                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
                                    verticalArrangement = Arrangement.spacedBy(6.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    busRoute!!.schedules.forEach {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(getComposeColorFromRGBAColor(it.color).copy(alpha = 0.1f))
                                                .width(IntrinsicSize.Max)
                                                .padding(6.dp)
                                        ) {
                                            Text(it.time)
                                        }
                                    }
                                }
                            }
                        }
                    }

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
            commercialLine = "10",
            rgbaColor = RGBAColor(
                red = 185,
                green = 102,
                blue = 161,
                alpha = 1
            ),
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
                    ),
                    schedules = listOf(
                        BusSchedule(
                            node = "Mercado de Vegueta",
                            tipology = "De lunes a viernes",
                            time = "06:55",
                            color = RGBAColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1
                            )
                        ),
                        BusSchedule(
                            node = "Mercado de Vegueta",
                            tipology = "Sábado",
                            time = "08:05",
                            color = RGBAColor(
                                red = 0,
                                green = 0,
                                blue = 0,
                                alpha = 0
                            )
                        ),
                        BusSchedule(
                            node = "Mercado de Vegueta",
                            tipology = "Domingo y festivo",
                            time = "07:50",
                            color = RGBAColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1
                            )
                        ),

                        BusSchedule(
                            node = "Tres Palmas",
                            tipology = "De lunes a viernes",
                            time = "06:10",
                            color = RGBAColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1
                            )
                        ),
                        BusSchedule(
                            node = "Tres Palmas",
                            tipology = "Sábado",
                            time = "07:10",
                            color = RGBAColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1
                            )
                        ),
                        BusSchedule(
                            node = "Tres Palmas",
                            tipology = "Domingo y festivo",
                            time = "08:35",
                            color = RGBAColor(
                                red = 0,
                                green = 0,
                                blue = 0,
                                alpha = 0
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
            openScheduleDialog = {}
        )
    }
}
