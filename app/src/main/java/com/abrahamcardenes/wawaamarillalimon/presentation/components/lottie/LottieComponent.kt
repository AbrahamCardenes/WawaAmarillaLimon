package com.abrahamcardenes.wawaamarillalimon.presentation.components.lottie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation

@Composable
fun LottieComponent(
    lottieComposition: LottieComposition?,
    preLoaderProgress: Float,
    modifier: Modifier = Modifier) {
    LottieAnimation(
        composition = lottieComposition,
        progress = { preLoaderProgress },
        modifier = modifier
    )
}