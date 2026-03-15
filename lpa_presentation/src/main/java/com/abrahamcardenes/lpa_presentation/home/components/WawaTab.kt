package com.abrahamcardenes.lpa_presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme

@Composable
fun WawaTab(title: String, isSelected: Boolean, onTab: () -> Unit, modifier: Modifier = Modifier) {
    Tab(
        selected = isSelected,
        onClick = onTab,
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
                .copy(textAlign = TextAlign.Center),
            modifier = Modifier.padding(vertical = 12.dp)
        )
    }
}

@PreviewLightDark
@Composable
fun WawaTabPreview() {
    WawaAmarillaLimonTheme {
        PrimaryTabRow(
            selectedTabIndex = 0
        ) {
            WawaTab(
                title = stringResource(R.string.stops),
                isSelected = true,
                onTab = {}
            )
            WawaTab(
                title = stringResource(R.string.favorites),
                isSelected = false,
                onTab = {}
            )
        }
    }
}
