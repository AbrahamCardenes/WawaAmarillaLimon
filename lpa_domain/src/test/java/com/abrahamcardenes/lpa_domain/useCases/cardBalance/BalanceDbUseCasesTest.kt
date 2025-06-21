package com.abrahamcardenes.lpa_domain.useCases.cardBalance

import com.abrahamcardenes.lpa_domain.fakes.mockedWawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

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

    @Test
    fun `Given a call to save card it should be delegated to the repository`() = runTest {
        coEvery {
            repository.saveCard(mockedWawaCardBalance())
        } returns Unit

        balanceDbUseCases.saveCard(mockedWawaCardBalance())
        coVerify {
            repository.saveCard(mockedWawaCardBalance())
        }
    }

    @Test
    fun `Given a call to delete card it should be delegated to the repository`() = runTest {
        coEvery {
            repository.deleteCard(mockedWawaCardBalance())
        } returns Unit

        balanceDbUseCases.deleteCard(mockedWawaCardBalance())
        coVerify {
            repository.deleteCard(mockedWawaCardBalance())
        }
    }

    @Test
    fun `Given a call to getAllCards it should be delegated to the repository and return a flow`() = runTest {
        coEvery {
            repository.getAllCardsFromDb()
        } returns flow {
            emit(listOf(mockedWawaCardBalance()))
        }

        val result = balanceDbUseCases.getAllCards().single()

        assertThat(result).isEqualTo(listOf(mockedWawaCardBalance()))

        coVerify {
            repository.getAllCardsFromDb()
        }
    }
}
