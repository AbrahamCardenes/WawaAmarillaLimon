package com.abrahamcardenes.wawaamarillalimon.domain.useCases.concessions

import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusRoutesRepository
import com.abrahamcardenes.wawaamarillalimon.fakes.busRouteFake
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetBusRouteUseCaseTest {
    private val repository = mockk<BusRoutesRepository>()
    private lateinit var getBusRouteUseCase: GetBusRouteUseCase

    @Before
    fun setup() {
        getBusRouteUseCase = GetBusRouteUseCase(repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given a call to bus route it should return a bus route`() = runTest {
        val expected = Result.Success(busRouteFake())
        coEvery {
            repository.getBusRoutes("50")
        } returns Result.Success(busRouteFake())

        assertThat(getBusRouteUseCase("50")).isEqualTo(expected)
        coVerify {
            repository.getBusRoutes("50")
        }
    }

    @Test
    fun `Given a call to bus route with mayusString it should call repository with lowercase string`() = runTest {
        val x47Bus = busRouteFake().copy(line = "X47")
        val expected = Result.Success(x47Bus)
        coEvery {
            repository.getBusRoutes("x47")
        } returns Result.Success(x47Bus)

        assertThat(getBusRouteUseCase("X47")).isEqualTo(expected)
        coVerify {
            repository.getBusRoutes("x47")
        }
    }
}
