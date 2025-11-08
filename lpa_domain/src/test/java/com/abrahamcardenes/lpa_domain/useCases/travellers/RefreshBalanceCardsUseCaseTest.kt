package com.abrahamcardenes.lpa_domain.useCases.travellers

import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.fakes.mockedWawaCardBalance
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class RefreshBalanceCardsUseCaseTest {
    private val repository = mockk<TravellersRepository>()
    private val crashlyticsService = mockk<CrashlyticsService>()
    private lateinit var refreshBalanceCardsUseCase: RefreshBalanceCardsUseCase

    @Before
    fun setup() {
        refreshBalanceCardsUseCase = RefreshBalanceCardsUseCase(
            repository = repository,
            crashlyticsService = crashlyticsService
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given 2 cards it should update both cards`() = runTest {
        val firstCard = mockedWawaCardBalance()
        val secondCard = mockedWawaCardBalance().copy(code = "12345", balance = 10.0, date = "03-02-2025 11:30:21")

        val expected = listOf(
            firstCard.copy(date = "03-07-2025 09:30:20", balance = 5.50),
            secondCard.copy(date = "03-07-2025 09:30:20", balance = 5.50)
        )

        coEvery {
            repository.getBalance(cardNumber = firstCard.code)
        } returns Result.Success(firstCard.copy(date = "03-07-2025 09:30:20", balance = 5.50))

        coEvery {
            repository.getBalance(cardNumber = secondCard.code)
        } returns Result.Success(secondCard.copy(date = "03-07-2025 09:30:20", balance = 5.50))

        val result = refreshBalanceCardsUseCase(
            wawaCards = listOf(
                firstCard,
                secondCard
            )
        )

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Given 2 cards Where one fails with unknown error it should return one updated and the original without updating AND log the error`() = runTest {
        val firstCard = mockedWawaCardBalance()
        val secondCard = mockedWawaCardBalance().copy(code = "12345", balance = 10.0, date = "03-02-2025 11:30:21")

        val expected = listOf(
            firstCard.copy(date = "03-07-2025 09:30:20", balance = 5.50),
            secondCard
        )

        coEvery {
            repository.getBalance(cardNumber = firstCard.code)
        } returns Result.Success(firstCard.copy(date = "03-07-2025 09:30:20", balance = 5.50))

        coEvery {
            crashlyticsService.logException(any<Throwable>())
        } returns Unit

        coEvery {
            repository.getBalance(cardNumber = secondCard.code)
        } returns Result.Error(DataError.Remote.UnknownError(Exception("Unknown exception from API call")))

        val result = refreshBalanceCardsUseCase(
            wawaCards = listOf(
                firstCard,
                secondCard
            )
        )

        assertThat(result).isEqualTo(expected)

        coVerify {
            repository.getBalance(any())
            repository.getBalance(any())
            crashlyticsService.logException(any<Throwable>())
        }
    }

    @Test
    fun `Given a card Where it fails with unknown null error it should return the original card AND log the error`() = runTest {
        val wawaCardBalance = mockedWawaCardBalance().copy(code = "12345", balance = 10.0, date = "03-02-2025 11:30:21")
        coEvery { crashlyticsService.logException(any()) } returns Unit

        coEvery {
            repository.getBalance(cardNumber = wawaCardBalance.code)
        } returns Result.Error(DataError.Remote.UnknownError(null))

        val result = refreshBalanceCardsUseCase(
            wawaCards = listOf(
                wawaCardBalance
            )
        )

        assertThat(result).isEqualTo(listOf(wawaCardBalance))

        coVerify {
            repository.getBalance(any())
            crashlyticsService.logException(
                match { it is Exception && it.message == "Null exception in Data Error Unknown" }
            )
        }
    }
}
