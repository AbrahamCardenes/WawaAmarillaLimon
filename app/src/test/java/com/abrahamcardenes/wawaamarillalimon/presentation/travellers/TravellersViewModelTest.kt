package com.abrahamcardenes.wawaamarillalimon.presentation.travellers

import app.cash.turbine.test
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetConcessionsUseCase
import com.abrahamcardenes.wawaamarillalimon.fakes.mockedConcessions
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.travellers.TravellersUiState
import com.abrahamcardenes.wawaamarillalimon.presentation.travellers.travellers.TravellersViewModel
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

class TravellersViewModelTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var travellersViewModel: TravellersViewModel
    private val getConcessionsUseCase = mockk<GetConcessionsUseCase>(relaxed = true)

    @Before
    fun setup() {
        travellersViewModel = TravellersViewModel(getConcessionsUseCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given initial status it should be loading and with empty items`() = runTest {
        assertThat(travellersViewModel.travellersState.value).isEqualTo(TravellersUiState())
    }

    @Test
    fun `Given a call to getConcessions use case it should return the concessions and loading state be false`() = runTest {
        coEvery {
            getConcessionsUseCase()
        } returns Result.Success(mockedConcessions())

        travellersViewModel.travellersState.test {
            val emission = awaitItem()
            assertThat(emission.concessions).isEqualTo(mockedConcessions())
            assertThat(emission.isLoading).isFalse()
        }
    }
}
