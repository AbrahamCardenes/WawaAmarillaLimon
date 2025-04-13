package com.abrahamcardenes.lpa_presentation.components.lottie

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation

@Composable
fun LottieComponent(lottieComposition: LottieComposition?, preLoaderProgress: Float, modifier: Modifier = Modifier) {
    LottieAnimation(
        composition = lottieComposition,
        progress = { preLoaderProgress },
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}
