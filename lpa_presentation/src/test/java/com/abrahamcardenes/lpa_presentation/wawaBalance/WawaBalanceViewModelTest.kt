package com.abrahamcardenes.lpa_presentation.wawaBalance

import app.cash.turbine.test
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.useCases.travellers.GetBalanceUseCase
import com.abrahamcardenes.lpa_presentation.coroutineRules.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WawaBalanceViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var wawaBalanceViewModel: WawaBalanceViewModel
    private val getBalanceUseCase = mockk<GetBalanceUseCase>(relaxed = true)

    @Before
    fun setup() {
        wawaBalanceViewModel = WawaBalanceViewModel(getBalanceUseCase = getBalanceUseCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given initial status it should be empty`() = runTest {
        assertThat(wawaBalanceViewModel.balanceUiState.value.wawaCards).isEmpty()
        assertThat(wawaBalanceViewModel.balanceUiState.value.cardNumber).isEmpty()
        coVerify(exactly = 0) {
            getBalanceUseCase(any())
        }
    }

    @Test
    fun `Given a valid search it should populate the list`() = runTest {
        val expectedBalance = WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21")
        coEvery {
            getBalanceUseCase("579997")
        } returns Result.Success(expectedBalance)
        wawaBalanceViewModel.onCardNumberChange("579997")
        wawaBalanceViewModel.getBalance()

        coVerify(exactly = 1) {
            getBalanceUseCase("579997")
        }

        wawaBalanceViewModel.balanceUiState.test {
            val latestEmission = awaitItem()
            assertThat(latestEmission.wawaCards).isNotEmpty()
            assertThat(latestEmission.cardNumber).isNotEmpty()
            assertThat(latestEmission).isEqualTo(
                BalanceUiState(
                    wawaCards = listOf(expectedBalance),
                    cardNumber = "579997"
                )
            )
        }
    }

    @Test
    fun `Given the same input two time it should only return one item`() = runTest {
        val expectedBalance = WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21")
        coEvery {
            getBalanceUseCase("579997")
        } returns Result.Success(expectedBalance)

        wawaBalanceViewModel.onCardNumberChange("579997")
        wawaBalanceViewModel.getBalance()

        wawaBalanceViewModel.balanceUiState.test {
            val emission = awaitItem()
            assertThat(emission).isEqualTo(
                BalanceUiState(
                    wawaCards = listOf(expectedBalance),
                    cardNumber = "579997"
                )
            )
            wawaBalanceViewModel.onCardNumberChange("579997")
            wawaBalanceViewModel.getBalance()
            // It does not emit because value is the same
            // However it calls the use case twice ;)
        }

        coVerify(exactly = 2) {
            getBalanceUseCase("579997")
        }
    }

    @Test
    fun `Given the two different inputs it should only return two items and the last one it should be the first`() = runTest {
        val expectedBalance = listOf(
            WawaCardBalance(code = "579990", balance = 4.2, date = "04-01-2023 13:52:51"),
            WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21")
        )
        coEvery {
            getBalanceUseCase("579997")
        } returns Result.Success(WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21"))

        coEvery {
            getBalanceUseCase("579990")
        } returns Result.Success(WawaCardBalance(code = "579990", balance = 4.2, date = "04-01-2023 13:52:51"))

        wawaBalanceViewModel.onCardNumberChange("579997")
        wawaBalanceViewModel.getBalance()

        wawaBalanceViewModel.balanceUiState.test {
            val emission = awaitItem()
            assertThat(emission).isEqualTo(
                BalanceUiState(
                    wawaCards = listOf(WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21")),
                    cardNumber = "579997"
                )
            )
        }
        wawaBalanceViewModel.onCardNumberChange("579990")
        wawaBalanceViewModel.getBalance()
        wawaBalanceViewModel.balanceUiState.test {
            val lastEmission = awaitItem()
            println(lastEmission.toString())
            assertThat(lastEmission).isEqualTo(
                BalanceUiState(
                    wawaCards = expectedBalance,
                    cardNumber = "579990"
                )
            )
        }

        coVerifySequence {
            getBalanceUseCase("579997")
            getBalanceUseCase("579990")
        }
    }

    @Test
    fun `Given an empty input it should not call the use case`() = runTest {
        wawaBalanceViewModel.getBalance()

        coVerify(exactly = 0) {
            getBalanceUseCase(any<String>())
        }

        wawaBalanceViewModel.balanceUiState.test {
            val latestEmission = awaitItem()
            assertThat(latestEmission.wawaCards).isEmpty()
            assertThat(latestEmission.cardNumber).isEmpty()
        }
    }
}
