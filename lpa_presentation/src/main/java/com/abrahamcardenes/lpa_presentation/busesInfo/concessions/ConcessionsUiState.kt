package com.abrahamcardenes.lpa_presentation.busesInfo.concessions

import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions

data class ConcessionsUiState(
    val isLoading: Boolean = true,
    val concessions: Concessions = Concessions(emptyList())
)
