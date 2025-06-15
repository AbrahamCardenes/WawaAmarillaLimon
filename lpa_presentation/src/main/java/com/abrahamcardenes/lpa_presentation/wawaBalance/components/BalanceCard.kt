package com.abrahamcardenes.lpa_presentation.wawaBalance.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme
import com.abrahamcardenes.lpa_presentation.utils.toLocalCurrency
import kotlinx.coroutines.delay

@Composable
fun BalanceCard(wawaCardBalance: WawaCardBalance, onDeleteAction: (WawaCardBalance) -> Unit, modifier: Modifier = Modifier) {
    var isItemSwiped by remember {
        mutableStateOf(false)
    }

    val dismissState = rememberSwipeToDismissBoxState()
    val swipeBackgroundColor by
        animateColorAsState(
            targetValue = when (dismissState.targetValue) {
                SwipeToDismissBoxValue.Settled -> Color.Transparent
                SwipeToDismissBoxValue.StartToEnd -> Color.Red
                SwipeToDismissBoxValue.EndToStart -> Color.Red
            },
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy
            )
        )

    val iconColor by
        animateColorAsState(
            targetValue = when (dismissState.targetValue) {
                SwipeToDismissBoxValue.Settled -> Color.Transparent
                SwipeToDismissBoxValue.StartToEnd -> Color.White
                SwipeToDismissBoxValue.EndToStart -> Color.White
            },
            animationSpec = tween(500)
        )

    val alpha by
        animateFloatAsState(
            targetValue = if (isItemSwiped) 0f else 1f,
            animationSpec = tween(250)
        )

    LaunchedEffect(dismissState) {
        snapshotFlow { dismissState.currentValue }
            .collect { value ->
                if (value != SwipeToDismissBoxValue.Settled) {
                    isItemSwiped = true
                    delay(350)
                    dismissState.reset()
                    onDeleteAction(wawaCardBalance)
                    isItemSwiped = false
                }
            }
    }

    SwipeToDismissBox(
        modifier = Modifier.alpha(alpha),
        state = dismissState,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(swipeBackgroundColor)
            ) {
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Spacer(Modifier.width(16.dp))
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(16.dp))
                }
            }
        }
    ) {
        OutlinedCard(modifier = modifier) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                BalanceTextAppended(
                    title = stringResource(R.string.card_number_title),
                    value = wawaCardBalance.code
                )
                BalanceTextAppended(
                    title = stringResource(R.string.update_date_title),
                    value = wawaCardBalance.date
                )
                BalanceTextAppended(
                    title = stringResource(R.string.balance_title),
                    value = wawaCardBalance.balance.toLocalCurrency().plus("€")
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
fun BalanceCardPreview() {
    WawaAmarillaLimonTheme {
        BalanceCard(
            wawaCardBalance = WawaCardBalance(
                code = "579997",
                balance = 6.60,
                date = "03-02-2025 17:18:21"
            ),
            onDeleteAction = {},
            modifier = Modifier
        )
    }
}
