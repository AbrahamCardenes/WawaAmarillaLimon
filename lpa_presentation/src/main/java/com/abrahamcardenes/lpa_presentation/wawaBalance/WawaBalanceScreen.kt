package com.abrahamcardenes.lpa_presentation.wawaBalance

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.components.notifications.NotificationMessage
import com.abrahamcardenes.lpa_presentation.components.textfields.BusTextField
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.uiModels.NotificationType
import com.abrahamcardenes.lpa_presentation.wawaBalance.components.BalanceCard
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay

@Composable
fun WawaBalanceScreenRoot(wawaBalanceViewModel: WawaBalanceViewModel = hiltViewModel()) {
    val uiState by wawaBalanceViewModel.balanceUiState.collectAsStateWithLifecycle()

    WawaBalanceContent(
        uiState = uiState,
        onCardNumberChange = { value ->
            if (value.isDigitsOnly()) {
                wawaBalanceViewModel.onCardNumberChange(value)
            }
        },
        onGetBalance = wawaBalanceViewModel::getBalance,
        updateErrorState = wawaBalanceViewModel::updateErrorState,
        onRefresh = wawaBalanceViewModel::refreshCards,
        onDeleteCard = wawaBalanceViewModel::removeCard,
        modifier = Modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WawaBalanceContent(
    uiState: BalanceUiState,
    onCardNumberChange: (String) -> Unit,
    updateErrorState: (Boolean) -> Unit,
    onDeleteCard: (WawaCardBalance) -> Unit,
    onRefresh: () -> Unit,
    onGetBalance: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()
    val keyboardController = LocalSoftwareKeyboardController.current

    var currentNumberOfCards by remember {
        mutableIntStateOf(uiState.wawaCards.size)
    }

    LaunchedEffect(uiState.wawaCards.size) {
        if (uiState.wawaCards.isEmpty()) return@LaunchedEffect

        if (currentNumberOfCards < uiState.wawaCards.size) {
            state.animateScrollToItem(uiState.wawaCards.size)
        }
        currentNumberOfCards = uiState.wawaCards.size
    }

    LaunchedEffect(uiState.errorHappened) {
        if (uiState.errorHappened) {
            delay(5.seconds)
            updateErrorState(false)
        }
    }

    AnimatedVisibility(uiState.errorHappened, modifier = Modifier.zIndex(2f)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            NotificationMessage(
                message = stringResource(R.string.balance_error),
                notificationType = NotificationType.ERROR,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PullToRefreshBox(
            isRefreshing = uiState.isRefreshing,
            onRefresh = onRefresh,
            modifier = Modifier
                .weight(1f)

        ) {
            LazyColumn(
                state = state,
                modifier = Modifier
                    .fillMaxSize()
                    .animateContentSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                items(uiState.wawaCards, key = { item: WawaCardBalance -> item.code }) {
                    Box(
                        modifier = Modifier.animateItem()
                    ) {
                        BalanceCard(
                            wawaCardBalance = it,
                            onDeleteAction = onDeleteCard,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 16.dp
                                )
                        )
                    }
                }
                item { Spacer(Modifier.height(8.dp)) }
            }
        }

        Row(
            modifier = Modifier
                .run {
                    fillMaxWidth()
                        .windowInsetsPadding(WindowInsets.ime)
                }
                .padding(
                    horizontal = 16.dp
                )
                .padding(
                    bottom = 16.dp
                ),
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
                modifier = Modifier
                    .weight(1f)

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
            updateErrorState = {},
            onRefresh = {},
            onDeleteCard = {},
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
