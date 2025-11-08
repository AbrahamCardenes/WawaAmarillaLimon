package com.abrahamcardenes.lpa_presentation.busesInfo.concessions

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abrahamcardenes.lpa_domain.models.common.RGBAColor
import com.abrahamcardenes.lpa_presentation.busesInfo.components.ConcessionCard
import com.abrahamcardenes.lpa_presentation.components.errors.CatError
import com.abrahamcardenes.lpa_presentation.components.loaders.LoadingCircles

@Composable
fun ConcessionsScreen(
    onNavigateToTimeTable: (String, RGBAColor) -> Unit,
    concessionsViewModel: ConcessionsViewModel = hiltViewModel<ConcessionsViewModel>(),
    modifier: Modifier = Modifier
) {
    val uiState by concessionsViewModel.concessionUiState.collectAsStateWithLifecycle()
    AnimatedContent(uiState.concessionState) { state ->
        when (state) {
            ConcessionState.Error -> {
                CatError(
                    onClick = {
                        concessionsViewModel.getConcessions()
                    },
                    message = stringResource(uiState.errorMessage),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize()
                )
            }

            ConcessionState.Loading -> LoadingCircles(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )

            ConcessionState.Success -> {
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
        }
    }
}
