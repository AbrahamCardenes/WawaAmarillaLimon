package com.abrahamcardenes.lpa_presentation.wawaBalance

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.BalanceDbUseCases
import com.abrahamcardenes.lpa_domain.useCases.travellers.GetBalanceUseCase
import com.abrahamcardenes.lpa_domain.useCases.travellers.RefreshBalanceCardsUseCase
import com.abrahamcardenes.lpa_presentation.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.lpa_presentation.fakes.TestsDispatchers
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
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
    private val crashlyticsService = mockk<CrashlyticsService>(relaxed = true)
    private val balanceDbUseCases = mockk<BalanceDbUseCases>(relaxed = true)
    private val refreshBalanceCardsUseCase = mockk<RefreshBalanceCardsUseCase>(relaxed = true)
    private val dispatchers = TestsDispatchers

    @Before
    fun setup() {
        wawaBalanceViewModel = WawaBalanceViewModel(
            getBalanceUseCase = getBalanceUseCase,
            crashlyticsService = crashlyticsService,
            balanceDbUseCases = balanceDbUseCases,
            refreshBalanceCardsUseCase = refreshBalanceCardsUseCase,
            dispatchers = dispatchers
        )
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

        coEvery {
            balanceDbUseCases.getAllCards()
        } returns flow {
            emit(listOf(expectedBalance))
        }

        coVerify(exactly = 1) {
            balanceDbUseCases.saveCard(wawaCard = expectedBalance)
            getBalanceUseCase("579997")
        }

        wawaBalanceViewModel.balanceUiState.test {
            val latestEmission = awaitItem()
            assertThat(latestEmission.errorHappened).isFalse()
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
    fun `Given a card that returns an error it should update the state to error`() = runTest {
        coEvery {
            getBalanceUseCase("579997")
        } returns Result.Error(DataError.Remote.RequestTimeout)

        wawaBalanceViewModel.onCardNumberChange("579997")
        wawaBalanceViewModel.getBalance()

        coVerify(exactly = 1) {
            getBalanceUseCase("579997")
        }

        wawaBalanceViewModel.balanceUiState.test {
            val latestEmission = awaitItem()
            assertThat(latestEmission.errorHappened).isTrue()
            assertThat(latestEmission.wawaCards).isEmpty()
            assertThat(latestEmission.cardNumber).isNotEmpty()
            assertThat(latestEmission).isEqualTo(
                BalanceUiState(
                    wawaCards = emptyList(),
                    cardNumber = "579997",
                    errorHappened = true
                )
            )
        }
    }

    @Test
    fun `Given the two different inputs it should only verify that it can save both`() = runTest {
        val expectedBalance = listOf(
            WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21"),
            WawaCardBalance(code = "579990", balance = 4.2, date = "04-01-2023 13:52:51")
        )
        coEvery {
            getBalanceUseCase("579997")
        } returns Result.Success(WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21"))

        coEvery {
            getBalanceUseCase("579990")
        } returns Result.Success(WawaCardBalance(code = "579990", balance = 4.2, date = "04-01-2023 13:52:51"))

        wawaBalanceViewModel.onCardNumberChange("579997")
        wawaBalanceViewModel.getBalance()
        wawaBalanceViewModel.onCardNumberChange("579990")
        wawaBalanceViewModel.getBalance()

        coEvery {
            balanceDbUseCases.getAllCards()
        } returns flow {
            emit(expectedBalance)
        }

        wawaBalanceViewModel.balanceUiState.test {
            val lastEmission = awaitItem()
            assertThat(lastEmission).isEqualTo(
                BalanceUiState(
                    wawaCards = expectedBalance,
                    cardNumber = "579990"
                )
            )
        }

        coVerify {
            getBalanceUseCase("579997")
            balanceDbUseCases.saveCard(WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21"))
            getBalanceUseCase("579990")
            balanceDbUseCases.saveCard(WawaCardBalance(code = "579990", balance = 4.2, date = "04-01-2023 13:52:51"))
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

    @Test
    fun `Given a card it should call the use case to delete it`() = runTest {
        val expectedBalance = WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21")
        wawaBalanceViewModel.removeCard(expectedBalance)
        coVerifySequence {
            balanceDbUseCases.deleteCard(expectedBalance)
        }
    }
}
