package com.abrahamcardenes.wawaamarillalimon.presentation.travellers

import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession

data class TravellersUiState(
    val concessions: List<Concession> = emptyList()
)
