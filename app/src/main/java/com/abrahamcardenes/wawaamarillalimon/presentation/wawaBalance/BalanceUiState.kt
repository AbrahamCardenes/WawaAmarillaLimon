package com.abrahamcardenes.wawaamarillalimon.presentation.wawaBalance

import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.WawaCardBalance

data class BalanceUiState(
    val cardNumber: String = "",
    val wawaCards: List<WawaCardBalance> = emptyList()
)
