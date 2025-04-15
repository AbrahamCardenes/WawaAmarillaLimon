package com.abrahamcardenes.lpa_presentation.components.errors

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.components.lottie.LottieComponent
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun CatError(onClick: () -> Unit, modifier: Modifier = Modifier, message: String) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.cat_lottie
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        useCompositionFrameRate = true
    )
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            LottieComponent(
                lottieComposition = preloaderLottieComposition,
                preLoaderProgress = preloaderProgress,
                modifier = Modifier.size(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(onClick = onClick) {
            Text(
                text = stringResource(R.string.retry),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun CatErrorPreview() {
    WawaAmarillaLimonTheme {
        CatError(
            message = stringResource(R.string.cat_error_5),
            onClick = {}
        )
    }
}
