package com.abrahamcardenes.lpa_presentation.home.components

import androidx.compose.material3.PrimaryTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.abrahamcardenes.lpa_presentation.R
import com.abrahamcardenes.lpa_presentation.theme.WawaAmarillaLimonTheme

@Composable
fun BusStopsTabs(currentPage: Int, selectedTab: Int, onAllTab: () -> Unit, onFavoritesTab: () -> Unit) {
    PrimaryTabRow(
        selectedTabIndex = currentPage
    ) {
        WawaTab(
            title = stringResource(R.string.stops),
            isSelected = selectedTab == currentPage,
            onTab = onAllTab
        )
        WawaTab(
            title = stringResource(R.string.favorites),
            isSelected = selectedTab == currentPage,
            onTab = onFavoritesTab
        )
    }
}

@PreviewLightDark
@Composable
fun BusStopsTabsPreview() {
    WawaAmarillaLimonTheme {
        BusStopsTabs(
            currentPage = 1,
            selectedTab = 1,
            onAllTab = { },
            onFavoritesTab = { }
        )
    }
}
