package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.presentation.components.loaders.LoadingCircles
import com.abrahamcardenes.wawaamarillalimon.presentation.components.textfields.BusTextField
import com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance.components.BalanceCard
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun WawaBalanceScreenRoot(wawaBalanceViewModel: WawaBalanceViewModel = hiltViewModel()) {
    val uiState by wawaBalanceViewModel.balanceUiState.collectAsStateWithLifecycle()
    WawaBalanceContent(
        uiState = uiState,
        onCardNumberChange = wawaBalanceViewModel::onCardNumberChange,
        onGetBalance = wawaBalanceViewModel::getBalance,
        modifier = Modifier
    )
}

@Composable
fun WawaBalanceContent(
    uiState: BalanceUiState,
    onCardNumberChange: (String) -> Unit,
    onGetBalance: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                16.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedContent(uiState.isLoading) { isLoading ->
            if (isLoading) {
                LoadingCircles()
            } else {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    if (uiState.wawaCardBalance != null) {
                        item {
                            BalanceCard(
                                wawaCardBalance = uiState.wawaCardBalance,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BusTextField(
                label = stringResource(R.string.put_here_card_number),
                value = uiState.cardNumber,
                onUserInput = onCardNumberChange,
                trailingIcon = null,
                modifier = Modifier.weight(1f)
            )

            FilledTonalIconButton(
                onClick = onGetBalance,
                modifier = Modifier
                    .clip(CircleShape)
                    .aspectRatio(1f)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
@PreviewLightDark()
fun WawaBalancePreview() {
    WawaAmarillaLimonTheme {
        WawaBalanceContent(
            uiState = BalanceUiState(),
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            onGetBalance = {},
            onCardNumberChange = {}
        )
    }
}
