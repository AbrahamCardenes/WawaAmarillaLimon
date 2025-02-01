package com.abrahamcardenes.wawaamarillalimon.presentation.components.lists

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.wawaamarillalimon.presentation.components.BusStopCard
import com.abrahamcardenes.wawaamarillalimon.presentation.components.textfields.BusTextField
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import kotlinx.coroutines.launch

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
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = busStops,
                key = { _, busStopDetail -> busStopDetail.stopNumber }
            ) { index, busStopDetail ->
                BusStopCard(
                    busStop = busStopDetail,
                    onIconClick = onSaveBusStop,
                    onClick = {
                        onBusStopClick(busStopDetail.stopNumber)

                    },
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .animateItem()
                )
            }
        }

        BusTextField(value = textFieldInput, onUserInput = { input ->
            onUserInput(input)
        })
    }
}
