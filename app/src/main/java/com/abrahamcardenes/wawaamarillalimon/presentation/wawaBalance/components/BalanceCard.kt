package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.presentation.utils.toLocalCurrency
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BalanceCard(wawaCardBalance: WawaCardBalance, modifier: Modifier = Modifier) {
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
            modifier = Modifier
        )
    }
}
