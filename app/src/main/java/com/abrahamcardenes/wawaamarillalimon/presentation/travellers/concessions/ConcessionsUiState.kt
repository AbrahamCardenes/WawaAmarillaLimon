package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.concessions

import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions.Concessions

data class ConcessionsUiState(
    val isLoading: Boolean = true,
    val concessions: Concessions = Concessions(emptyList())
)
