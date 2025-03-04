package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.travellers

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
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.components.ConcessionCard

@Composable
fun TravellersScreenRoot(
    onNavigateToTimeTable: (Int) -> Unit,
    travellersViewModel: TravellersViewModel = hiltViewModel<TravellersViewModel>(),
    modifier: Modifier = Modifier
) {
    val uiState by travellersViewModel.travellersState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier
            .padding(
                horizontal = 16.dp
            )
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(uiState.concessions) {
            ConcessionCard(concession = it, onClick = onNavigateToTimeTable)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
