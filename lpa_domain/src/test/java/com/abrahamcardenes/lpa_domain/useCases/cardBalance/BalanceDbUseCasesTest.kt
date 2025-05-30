package com.abrahamcardenes.lpa_domain.useCases.cardBalance

import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.After
import org.junit.Before

class BalanceDbUseCasesTest {

    private val repository = mockk<TravellersRepository>()
    private lateinit var balanceDbUseCases: BalanceDbUseCases

    @Before
    fun setup() {
        balanceDbUseCases = BalanceDbUseCases(
            saveCard = SaveBalanceUseCase(repository),
            getAllCards = GetAllCardsUseCase(
                repository = repository
            ),
            deleteCard = DeleteBalanceUseCase(repository)
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }
}
