package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.abrahamcardenes.wawaamarillalimon.R
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun BalanceTextAppended(title: String, value: String) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = MaterialTheme.typography.titleMedium.toSpanStyle()
            ) {
                append(title)
                append(" ")
            }
            withStyle(
                style = MaterialTheme.typography.bodyLarge.toSpanStyle()
            ) {
                append(value)
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun BalanceTextAppendedPreview() {
    WawaAmarillaLimonTheme {
        BalanceTextAppended(
            title = stringResource(R.string.card_number_title),
            value = "579997"
        )
    }
}
