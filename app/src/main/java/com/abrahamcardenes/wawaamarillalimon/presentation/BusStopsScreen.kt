package com.abrahamcardenes.wawaamarillalimon.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.presentation.components.BusStopCard
import com.abrahamcardenes.wawaamarillalimon.presentation.components.lottie.LottieComponent
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.launch

@Composable
fun BusStopsScreenRoot(busStopsViewModel: BusStopsViewModel = hiltViewModel<BusStopsViewModel>(), modifier: Modifier = Modifier) {
    val uiState = busStopsViewModel.uiState.collectAsStateWithLifecycle()
    BusStopsScreen(
        uiState = uiState.value,
        onBusStopClick = { stopNumber ->
            busStopsViewModel.getBusStopDetail(stopNumber)
        },
        onUserInput = busStopsViewModel::updateUserInput,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
private fun BusStopsScreen(
    uiState: BusStopsUiState,
    onBusStopClick: (Int) -> Unit,
    onUserInput: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.lottie_loader
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        useCompositionFrameRate = true
    )

    AnimatedContent(
        targetState = uiState.isLoading,
        label = "animation-loading-bus-stops"
    ) { isLoading ->
        if (isLoading) {
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                LottieComponent(
                    lottieComposition = preloaderLottieComposition,
                    preLoaderProgress = preloaderProgress,
                    modifier = Modifier.size(200.dp)
                )
            }
        } else {
            Column(
                modifier =
                modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    itemsIndexed(
                        items = uiState.busStops,
                        key = { _, busStopDetail -> busStopDetail.stopNumber }
                    ) { index, busStopDetail ->
                        BusStopCard(
                            busStop = busStopDetail,
                            onClick = {
                                onBusStopClick(busStopDetail.stopNumber)
                                coroutineScope.launch {
                                    lazyListState.animateScrollToItem(index)
                                }
                            },
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .animateContentSize(
                                    animationSpec =
                                    spring(
                                        stiffness = Spring.StiffnessLow,
                                        dampingRatio = Spring.DampingRatioLowBouncy
                                    )
                                )
                        )
                    }
                }

                OutlinedTextField(
                    value = uiState.userInput,
                    onValueChange = { value ->
                        onUserInput(value)
                        coroutineScope.launch {
                            lazyListState.animateScrollToItem(0)
                        }
                    },
                    singleLine = true,
                    label = {
                        Text(
                            "Introduzca el número o dirección de la parada",
                            style = MaterialTheme.typography.labelLarge
                        )
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
                    },
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .windowInsetsPadding(WindowInsets.ime)
                )
            }
        }
    }
}

@Composable()
@PreviewLightDark
fun BusStopsScreenPreview() {
    WawaAmarillaLimonTheme {
        BusStopsScreen(
            uiState =
            BusStopsUiState().copy(
                busStops =
                listOf(
                    UiBusStopDetail(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        availableBusLines = emptyList(),
                        isExpanded = false
                    )
                )
            ),
            onUserInput = {},
            onBusStopClick = {}
        )
    }
}
