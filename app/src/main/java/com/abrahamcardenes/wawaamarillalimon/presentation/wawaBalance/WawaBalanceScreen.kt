package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.wawaamarillalimon.presentation.components.textfields.BusTextField
import com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance.components.BalanceCard
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme
import kotlinx.coroutines.delay

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
    val state = rememberLazyListState()
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(uiState.wawaCards.size) {
        if (uiState.wawaCards.isEmpty()) return@LaunchedEffect
        delay(250)
        state.animateScrollToItem(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                16.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            state = state,
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(uiState.wawaCards, key = { item: WawaCardBalance -> item.code }) {
                BalanceCard(
                    wawaCardBalance = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItem()
                )
            }

            item { Spacer(Modifier.height(8.dp)) }
        }

        Row(
            modifier = Modifier.run {
                fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.ime)
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BusTextField(
                label = stringResource(R.string.put_here_card_number),
                keyboardType = KeyboardType.Number,
                value = uiState.cardNumber,
                onUserInput = onCardNumberChange,
                keyboardActions = KeyboardActions(onDone = {
                    onGetBalance()
                    keyboardController?.hide()
                }),
                trailingIcon = null,
                modifier = Modifier.weight(1f)
            )

            FilledTonalIconButton(
                onClick = onGetBalance,
                modifier = Modifier
                    .offset(y = 3.5.dp)
                    .height(IntrinsicSize.Max)
                    .width(IntrinsicSize.Max)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)

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
            uiState = BalanceUiState(
                wawaCards = mutableListOf(
                    WawaCardBalance(
                        code = "579997",
                        balance = 6.60,
                        date = "03-02-2025 17:18:21"
                    )
                )
            ),

            onCardNumberChange = {},
            onGetBalance = {},
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
