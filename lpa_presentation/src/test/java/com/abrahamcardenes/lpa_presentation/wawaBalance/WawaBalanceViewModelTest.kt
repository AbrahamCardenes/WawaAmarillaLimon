@file:OptIn(ExperimentalCoroutinesApi::class)

package com.abrahamcardenes.lpa_presentation.wawaBalance

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.travellers.WawaCardBalance
import com.abrahamcardenes.lpa_domain.useCases.cardBalance.BalanceDbUseCases
import com.abrahamcardenes.lpa_domain.useCases.travellers.FetchWawaBalanceUseCase
import com.abrahamcardenes.lpa_domain.useCases.travellers.GetBalanceUseCase
import com.abrahamcardenes.lpa_presentation.coroutineRules.CoroutineTestExtension
import com.abrahamcardenes.lpa_presentation.fakes.TestsDispatchers
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.runner.junit4.FunSpec
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow

class WawaBalanceViewModelTest : FunSpec({
    lateinit var wawaBalanceViewModel: WawaBalanceViewModel
    val getBalanceUseCase = mockk<GetBalanceUseCase>(relaxed = true)
    val crashlyticsService = mockk<CrashlyticsService>(relaxed = true)
    val balanceDbUseCases = mockk<BalanceDbUseCases>(relaxed = true) // TODO: fake emitting class for DB getAll.
    val fetchWawaBalanceUseCase = mockk<FetchWawaBalanceUseCase>(relaxed = true)
    val dispatchers = TestsDispatchers

    extensions(CoroutineTestExtension())

    beforeTest {
        wawaBalanceViewModel = WawaBalanceViewModel(
            getBalanceUseCase = getBalanceUseCase,
            crashlyticsService = crashlyticsService,
            balanceDbUseCases = balanceDbUseCases,
            fetchWawaBalanceUseCase = fetchWawaBalanceUseCase,
            dispatchers = dispatchers
        )
    }

    afterTest {
        clearAllMocks()
    }

    test("Given initial status it should be empty") {
        wawaBalanceViewModel.balanceUiState.value.wawaCards shouldBe emptyList()
        wawaBalanceViewModel.balanceUiState.value.cardNumber shouldBe ""
        coVerify(exactly = 0) {
            getBalanceUseCase(any())
        }
    }

    test("Given a valid search it should populate the list") {
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
            latestEmission.errorHappened shouldBe false

            latestEmission.wawaCards.shouldHaveSize(1)
            latestEmission.cardNumber shouldNotBe ""
            latestEmission shouldBe BalanceUiState(
                wawaCards = listOf(expectedBalance),
                cardNumber = "579997"
            )
        }
    }

    test("Given a card that returns an error it should update the state to error") {
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
            latestEmission.errorHappened shouldBe true
            latestEmission.wawaCards shouldBe emptyList()
            latestEmission.cardNumber shouldNotBe ""
            latestEmission shouldBe BalanceUiState(
                wawaCards = emptyList(),
                cardNumber = "579997",
                errorHappened = true
            )
        }
    }

    test("Given the two different inputs it should only verify that it can save both") {
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
            lastEmission shouldBe BalanceUiState(
                wawaCards = expectedBalance,
                cardNumber = "579990"
            )
        }

        coVerify {
            getBalanceUseCase("579997")
            balanceDbUseCases.saveCard(WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21"))
            getBalanceUseCase("579990")
            balanceDbUseCases.saveCard(WawaCardBalance(code = "579990", balance = 4.2, date = "04-01-2023 13:52:51"))
        }
    }

    test("Given an empty input it should not call the use case") {
        wawaBalanceViewModel.getBalance()

        coVerify(exactly = 0) {
            getBalanceUseCase(any<String>())
        }

        wawaBalanceViewModel.balanceUiState.test {
            val latestEmission = awaitItem()
            latestEmission.wawaCards shouldBe emptyList()
            latestEmission.cardNumber shouldBe ""
        }
    }

    test("Given a card it should call the use case to delete it") {
        val expectedBalance = WawaCardBalance(code = "579997", balance = 6.60, date = "03-02-2025 17:18:21")
        wawaBalanceViewModel.removeCard(expectedBalance)
        coVerifySequence {
            balanceDbUseCases.deleteCard(expectedBalance)
        }
    }
})
