package com.abrahamcardenes.wawaamarillalimon.presentation.travellers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TravellersScreenRoot(travellersViewModel: TravellersViewModel = hiltViewModel<TravellersViewModel>(), modifier: Modifier = Modifier) {
    val uiState by travellersViewModel.travellersState.collectAsStateWithLifecycle()

    LazyColumn(modifier = modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(uiState.buses) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "busNumber: " + it.busNumber)
                    Text(text = "commercialName: " + it.commercialName)
                    Text(text = "name: " + it.name)
                    Text(text = "color: " + it.color)
                }
            }
        }
    }
}
