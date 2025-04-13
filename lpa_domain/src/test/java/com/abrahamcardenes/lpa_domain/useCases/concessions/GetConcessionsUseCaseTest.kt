package com.abrahamcardenes.lpa_domain.useCases.concessions

import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.fakes.mockedConcessionsDetails
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.lpa_domain.repositories.BusRoutesRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetConcessionsUseCaseTest {
    private val repository = mockk<BusRoutesRepository>()
    private lateinit var getConcessionsUseCase: GetConcessionsUseCase

    @Before
    fun setup() {
        getConcessionsUseCase = GetConcessionsUseCase(repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given a call to get concessions it should return a list of concessions`() = runTest {
        val expected = Result.Success(
            Concessions(mockedConcessionsDetails())
        )

        coEvery {
            repository.getLines()
        } returns Result.Success(Concessions(mockedConcessionsDetails()))

        val result = getConcessionsUseCase()
        assertThat(result).isEqualTo(expected)
    }
}
