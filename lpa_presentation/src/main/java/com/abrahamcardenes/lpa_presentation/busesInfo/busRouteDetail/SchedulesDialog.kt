package com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.components.TimeBox
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels.ScheduleUi
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels.TimeUi

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun SchedulesDialog(showDialog: Boolean, openOrCloseScheduleDialog: () -> Unit, busRouteSchedule: List<ScheduleUi>) {
    AnimatedVisibility(showDialog) {
        Dialog(onDismissRequest = openOrCloseScheduleDialog) {
            Card(
                modifier = Modifier
                    .heightIn(max = 500.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .verticalScroll(rememberScrollState())
                        .padding(8.dp)
                ) {
                    Text(
                        text = busRouteSchedule.first().node,
                        style = MaterialTheme.typography.headlineMedium.copy(textDecoration = TextDecoration.Underline),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    busRouteSchedule.forEach {
                        Text(
                            text = it.typology,
                            style = MaterialTheme.typography.titleMedium.copy(fontStyle = FontStyle.Italic),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp),
                            textAlign = TextAlign.Start
                        )

                        FlowRow(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            maxItemsInEachRow = 4,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp)
                        ) {
                            it.time.forEach {
                                TimeBox(timeUi = it)
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
@OptIn(ExperimentalLayoutApi::class)
fun SchedulesDialogPreview() {
    MaterialTheme {
        SchedulesDialog(
            showDialog = true,
            openOrCloseScheduleDialog = {},
            busRouteSchedule = listOf(
                ScheduleUi(
                    node = "Teatro",
                    typology = "Lunes a Viernes",
                    time = listOf(
                        TimeUi(
                            time = "06:00",
                            color = RGBAColor(red = 245, green = 245, blue = 245, alpha = 1)
                        ),
                        TimeUi(
                            time = "06:15",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        ),
                        TimeUi(
                            time = "06:30",
                            color = RGBAColor(red = 245, green = 245, blue = 245, alpha = 1)
                        ),
                        TimeUi(
                            time = "06:45",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        ),
                        TimeUi(
                            time = "07:00",
                            color = RGBAColor(red = 245, green = 245, blue = 245, alpha = 1)
                        ),
                        TimeUi(
                            time = "07:15",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        ),
                        TimeUi(
                            time = "07:30",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        )
                    )
                ),
                ScheduleUi(
                    node = "Teatro",
                    typology = "Domingos y Festivos",
                    time = listOf(
                        TimeUi(
                            time = "06:00",
                            color = RGBAColor(red = 245, green = 245, blue = 245, alpha = 1)
                        ),
                        TimeUi(
                            time = "06:15",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        ),
                        TimeUi(
                            time = "06:30",
                            color = RGBAColor(red = 245, green = 245, blue = 245, alpha = 1)
                        ),
                        TimeUi(
                            time = "06:45",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        ),
                        TimeUi(
                            time = "07:00",
                            color = RGBAColor(red = 245, green = 245, blue = 245, alpha = 1)
                        ),
                        TimeUi(
                            time = "07:15",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        ),
                        TimeUi(
                            time = "07:30",
                            color = RGBAColor(red = 0, green = 0, blue = 0, alpha = 1)
                        )
                    )
                )
            )
        )
    }
}
