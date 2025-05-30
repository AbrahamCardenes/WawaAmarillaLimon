package com.abrahamcardenes.lpa_domain.useCases.cardBalance

data class BalanceDbUseCases(
    val saveCard: SaveBalanceUseCase,
    val getAllCards: GetAllCardsUseCase,
    val deleteCard: DeleteBalanceUseCase
)
