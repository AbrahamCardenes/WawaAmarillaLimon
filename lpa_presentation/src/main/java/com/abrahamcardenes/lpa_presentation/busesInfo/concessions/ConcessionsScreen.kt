package com.abrahamcardenes.lpa_presentation.busesInfo.concessions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.abrahamcardenes.lpa_presentation.busesInfo.components.ConcessionCard

@Composable
fun ConcessionsScreen(
    onNavigateToTimeTable: (String, RGBAColor) -> Unit,
    concessionsViewModel: ConcessionsViewModel = hiltViewModel<ConcessionsViewModel>(),
    modifier: Modifier = Modifier
) {
    val uiState by concessionsViewModel.concessionUiState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(uiState.concessions.concessions) {
            ConcessionCard(
                concession = it,
                onClick = onNavigateToTimeTable,
                modifier = Modifier.padding(
                    horizontal = 16.dp
                )
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
