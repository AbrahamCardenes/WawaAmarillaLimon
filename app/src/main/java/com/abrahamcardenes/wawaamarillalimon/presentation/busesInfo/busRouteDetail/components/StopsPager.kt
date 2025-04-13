package com.abrahamcardenes.wawaamarillalimon.presentation.busesInfo.busRouteDetail.components

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.ui.theme.WawaAmarillaLimonTheme

@Composable
fun StopsPager(
    pagerState: PagerState,
    selectedIndex: Int,
    availableGoRouteStops: List<RouteStop>,
    availableBackRouteStops: List<RouteStop>
) {
    HorizontalPager(
        state = pagerState
    ) {
        if (selectedIndex == 0) {
            AvailableStopsByVariant(
                availableRouteStops = availableGoRouteStops
            )
        }

        if (selectedIndex == 1) {
            AvailableStopsByVariant(
                availableRouteStops = availableBackRouteStops
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun StopsPagerPreview() {
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    WawaAmarillaLimonTheme {
        StopsPager(
            availableGoRouteStops = emptyList(),
            availableBackRouteStops = emptyList(),
            selectedIndex = pagerState.currentPage,
            pagerState = pagerState
        )
    }
}
