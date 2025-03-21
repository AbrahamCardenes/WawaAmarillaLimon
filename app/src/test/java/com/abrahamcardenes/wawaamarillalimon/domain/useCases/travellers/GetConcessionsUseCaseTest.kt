package com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers

import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusRoutesRepository
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.TravellersRepository
import com.abrahamcardenes.wawaamarillalimon.fakes.mockedConcessions
import com.abrahamcardenes.wawaamarillalimon.fakes.mockedConcessionsDetails
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
