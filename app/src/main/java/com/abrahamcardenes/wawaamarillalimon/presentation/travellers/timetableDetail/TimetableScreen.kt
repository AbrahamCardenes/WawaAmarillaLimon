package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionSchedule
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.TimetableInfo
import com.abrahamcardenes.wawaamarillalimon.presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components.AvailablePaths
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components.ConcessionInformationDashboard
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components.ConcessionNodesTabRow
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail.components.TimetableTopBar
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun TimetableScreenRoot(
    busNumber: Int,
    timetableViewModel: TimetableViewModel = hiltViewModel<TimetableViewModel>(),
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        timetableViewModel.getTimetable(busIdNumber = busNumber)
    }

    val busTimetableUiState by timetableViewModel.uiState.collectAsStateWithLifecycle()

    TimetableUi(
        busNumber = busNumber,
        uiState = busTimetableUiState,
        onNavigateBack = onNavigateBack,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TimetableUi(busNumber: Int, uiState: TimetableUiState, onNavigateBack: () -> Unit, modifier: Modifier = Modifier) {
    val timetableInfo = uiState.timetableInfo
    val scrollState = rememberLazyListState()
    var tabSelected by remember { mutableIntStateOf(0) }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

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
                    TimetableTopBar(
                        busNumber = busNumber,
                        line = timetableInfo!!.timetables[tabSelected].lineId,
                        onNavigateBack = onNavigateBack,
                        scrollBehavior = scrollBehavior
                    )
                },
                modifier = modifier
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
                            nodes = timetableInfo!!.timetables.map { timetableInfo -> timetableInfo.node },
                            onTabClick = {
                                tabSelected = it
                            },
                            modifier = Modifier.zIndex(1f)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        ConcessionInformationDashboard(
                            timetableInfo = timetableInfo!!.timetables[tabSelected],
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        AvailablePaths(
                            paths = timetableInfo!!.timetables[tabSelected].routes,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    items(timetableInfo!!.timetables[tabSelected].concessionStops) {
                        Card(
                            shape = RectangleShape,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                it.name,
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
        TimetableUi(
            busNumber = 10,
            onNavigateBack = {},
            uiState = TimetableUiState(
                isLoading = false,
                timetableInfo = BusTimetables(
                    timetables = listOf(
                        TimetableInfo(
                            lineId = "Teatro - Hosp. Dr. Negrín (Exprés)",
                            node = "Teatro",
                            notes = "Sábado, domingo y festivo no circula",
                            warning = "GC-1 Collapse",
                            routes = listOf(
                                RoutePaths(
                                    type = "A",
                                    hexColor = "#009036",
                                    notes = "Por las Majadillas"
                                )
                            ),
                            concessionStops = listOf(
                                ConcessionStop(
                                    name = "Teatro",
                                    type = listOf("A")
                                ),
                                ConcessionStop(
                                    name = "Hospital Dr. Negrín (Consultas Externas)",
                                    type = listOf("A")
                                )
                            ),
                            schedules = listOf(
                                ConcessionSchedule(
                                    availableDays = "De lunes a viernes",
                                    times = listOf(
                                        "06:15",
                                        "06:40",
                                        "22:35"
                                    )
                                )
                            )
                        ),
                        TimetableInfo(
                            lineId = "Hosp. Dr. Negrín - Teatro (Exprés)",
                            node = "Hosp. Dr. Negrín",
                            notes = "Sábado, domingo y festivo no circula",
                            warning = "",
                            routes = listOf(
                                RoutePaths(
                                    type = "B",
                                    hexColor = "#009036",
                                    notes = ""
                                )
                            ),
                            concessionStops = listOf(
                                ConcessionStop(
                                    name = "Hospital Dr. Negrín (Consultas Externas)",
                                    type = listOf("B")
                                ),
                                ConcessionStop(
                                    name = "Av. de Canarias (San Telmo)",
                                    type = listOf("B")
                                ),
                                ConcessionStop(
                                    name = "Teatro",
                                    type = listOf("B")
                                )
                            ),
                            schedules = listOf(
                                ConcessionSchedule(
                                    availableDays = "De lunes a viernes",
                                    times = listOf(
                                        "06:40",
                                        "07:10",
                                        "22:05"
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}
