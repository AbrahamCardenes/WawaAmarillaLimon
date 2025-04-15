package com.abrahamcardenes.lpa_presentation.destinations.busesInfo

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.lpa_domain.useCases.concessions.GetConcessionsUseCase
import com.abrahamcardenes.lpa_presentation.busesInfo.concessions.ConcessionState
import com.abrahamcardenes.lpa_presentation.busesInfo.concessions.ConcessionsUiState
import com.abrahamcardenes.lpa_presentation.busesInfo.concessions.ConcessionsViewModel
import com.abrahamcardenes.lpa_presentation.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.lpa_presentation.fakes.mockedConcessionsDetails
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ConcessionsViewModelTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var concessionsViewModel: ConcessionsViewModel
    private val getConcessionsUseCase = mockk<GetConcessionsUseCase>(relaxed = true)

    @Before
    fun setup() {
        concessionsViewModel = ConcessionsViewModel(getConcessionsUseCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given initial status it should be loading and with empty items`() = runTest {
        assertThat(concessionsViewModel.concessionUiState.value).isEqualTo(ConcessionsUiState())
    }

    @Test
    fun `Given a call to getConcessions use case it should return the concessions and loading state be false`() = runTest {
        coEvery {
            getConcessionsUseCase()
        } returns Result.Success(Concessions(mockedConcessionsDetails()))

        concessionsViewModel.concessionUiState.test {
            val emission = awaitItem()
            assertThat(emission.concessions).isEqualTo(Concessions(mockedConcessionsDetails()))
            assertThat(emission.concessionState).isEqualTo(ConcessionState.Success)
        }
    }

    @Test
    fun `When getConcessions returns an error it should update state to error`() = runTest {
        coEvery {
            getConcessionsUseCase()
        } returns Result.Error(DataError.Remote.Unauthorized)

        concessionsViewModel.concessionUiState.test {
            val emission = awaitItem()
            assertThat(emission.concessions).isEqualTo(Concessions(emptyList()))
            assertThat(emission.concessionState).isEqualTo(ConcessionState.Error)
        }
    }
}
