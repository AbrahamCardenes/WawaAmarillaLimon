package com.abrahamcardenes.lpa_presentation.components.loaders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.components.lottie.LottieComponent
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LoadingCircles(modifier: Modifier = Modifier) {
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

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LottieComponent(
            lottieComposition = preloaderLottieComposition,
            preLoaderProgress = preloaderProgress,
            modifier = Modifier.size(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingCirclesPreview() {
    WawaAmarillaLimonTheme {
        LoadingCircles()
    }
}
