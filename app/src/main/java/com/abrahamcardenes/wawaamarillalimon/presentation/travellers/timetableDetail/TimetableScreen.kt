package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.timetableDetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun TimetableScreenRoot(busNumber: Int, modifier: Modifier = Modifier) {
    TimetableUi(busNumber = busNumber, modifier = modifier)
}

@Composable
fun TimetableUi(busNumber: Int, modifier: Modifier = Modifier) {
    Text("Hello timetable $busNumber")
}

@Composable
@PreviewLightDark
fun TimetablePreview() {
    WawaAmarillaLimonTheme {
        TimetableUi(
            busNumber = 10
        )
    }
}
