package com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops

import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.fakes.fakeBusStopDetail
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

class GetBusDetailUseCaseTest {

    private val repository = mockk<BusStopsRepository>(relaxed = true)
    private lateinit var getBusDetailUseCase: GetBusDetailUseCase

    @Before
    fun setup() {
        getBusDetailUseCase = GetBusDetailUseCase(repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `When passing a stop number it should return the detail`() = runTest {
        val expected = Result.Success(fakeBusStopDetail())
        coEvery {
            repository.getBusDetailStop(stopNumber = 79)
        } returns flow { emit(expected) }

        assertThat(getBusDetailUseCase(stopNumber = 79).single()).isEqualTo(expected)

        coVerify(exactly = 1) {
            repository.getBusDetailStop(stopNumber = 79)
        }
    }
}
