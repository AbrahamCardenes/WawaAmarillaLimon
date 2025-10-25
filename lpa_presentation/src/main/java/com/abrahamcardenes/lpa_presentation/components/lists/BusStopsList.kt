package com.abrahamcardenes.lpa_presentation.components.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.components.cards.BusStopCard
import com.abrahamcardenes.lpa_presentation.components.textfields.BusTextField
import com.abrahamcardenes.lpa_presentation.components.textfields.BusTextFieldConfig
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail

@Composable
fun BusStopsList(
    busStops: List<UiBusStopDetail>,
    textFieldInput: String,
    onSaveBusStop: (UiBusStopDetail) -> Unit,
    onBusStopClick: (Int) -> Unit,
    onUserInput: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val lazyListState = rememberLazyListState()
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(
                items = busStops,
                key = { busStopDetail -> busStopDetail.stopNumber }
            ) { busStopDetail ->
                BusStopCard(
                    busStop = busStopDetail,
                    onIconClick = onSaveBusStop,
                    onClick = {
                        onBusStopClick(busStopDetail.stopNumber)
                    },
                    modifier =
                    Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .animateItem()
                )
            }

            item {
                Spacer(modifier.fillParentMaxHeight(0.4f))
            }
        }

        BusTextField(
            busTextFieldConfig = BusTextFieldConfig(
                label = stringResource(R.string.search_bus_stop_textfield),
                value = textFieldInput
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
