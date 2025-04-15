package com.abrahamcardenes.lpa_presentation.busesInfo.concessions

import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions

data class ConcessionsUiState(
    val concessions: Concessions = Concessions(emptyList()),
    val concessionState: ConcessionState = ConcessionState.Loading,
    val errorMessage: Int = -1
)


