package com.abrahamcardenes.lpa_presentation.wawaBalance

import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance

data class BalanceUiState(
    val cardNumber: String = "",
    val wawaCards: List<WawaCardBalance> = emptyList(),
    val errorHappened: Boolean = false,
    val isRefreshing: Boolean = false,
    val newCardAdded: Boolean = false
)
