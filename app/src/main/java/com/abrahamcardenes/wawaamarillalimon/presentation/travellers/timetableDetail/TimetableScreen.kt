package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun TimetableScreenRoot(
    busNumber: Int,
    timetableViewModel: TimetableViewModel = hiltViewModel<TimetableViewModel>(),
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        timetableViewModel.getTimetable(busIdNumber = busNumber)
    }

    val busTimetableUiState by timetableViewModel.uiState.collectAsStateWithLifecycle()

    TimetableUi(
        busNumber = busNumber,
        busTimetableUiState = busTimetableUiState,
        modifier = modifier
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TimetableUi(busNumber: Int, busTimetableUiState: TimetableUiState, modifier: Modifier = Modifier) {
    val timetableInfo = busTimetableUiState.timetableInfo
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Text("Hello timetable $busNumber")
        Text(busTimetableUiState.toString())

        if (timetableInfo != null) {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                maxItemsInEachRow = 4
            ) {
                timetableInfo.timetables.first().schedules.first().times.map {
                    Text(it)
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
            busTimetableUiState = TimetableUiState()
        )
    }
}
