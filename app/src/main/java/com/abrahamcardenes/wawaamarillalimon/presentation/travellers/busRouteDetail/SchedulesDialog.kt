package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.getComposeColorFromRGBAColor

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun SchedulesDialog(uiState: BusRouteUiState, openOrCloseScheduleDialog: () -> Unit, busRouteSchedule: List<ScheduleUi>) {
    AnimatedVisibility(uiState.showDialog) {
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
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    busRouteSchedule.forEach {
                        Text(
                            text = it.typology,
                            style = MaterialTheme.typography.titleMedium,
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
                                val backgroundColor = if (it.color == RGBAColor(
                                        red = 245,
                                        green = 245,
                                        blue = 245,
                                        alpha = 1
                                    )
                                ) {
                                    Color.Transparent
                                } else {
                                    getComposeColorFromRGBAColor(it.color).copy(alpha = 0.2f)
                                }

                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .border(
                                            width = 1.dp,
                                            color = MaterialTheme.colorScheme.onBackground,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .background(backgroundColor)
                                        .width(IntrinsicSize.Max)
                                        .padding(8.dp)
                                ) {
                                    Text(
                                        it.time,
                                        style = MaterialTheme.typography.titleSmall
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
