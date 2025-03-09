package com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops

import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class SaveOrDeleteBusStopUseCaseTest {
    private val busStopsRepository = mockk<BusStopsRepository>()
    private lateinit var saveOrDeleteBusStopUseCase: SaveOrDeleteBusStopUseCase

    @Before
    fun setup() {
        saveOrDeleteBusStopUseCase = SaveOrDeleteBusStopUseCase(busStopsRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `When invoking saveOrDeleteBusStopUseCase and the object is mark as not in DB it should save the bus stop`() = runTest {
        val busStop = BusStop(
            addressName = "TEATRO, 99",
            stopNumber = 99,
            isSavedInDb = false
        )

        coEvery {
            busStopsRepository.saveStops(busStop)
        } returns Unit

        saveOrDeleteBusStopUseCase(busStop)

        coVerify(exactly = 1) {
            busStopsRepository.saveStops(busStop)
        }

        coVerify(exactly = 0) {
            busStopsRepository.deleteBusStop(busStop)
        }
    }

    @Test
    fun `When invoking saveOrDeleteBusStopUseCase and the object is mark as is in DB it should delete the bus stop`() = runTest {
        val busStop = BusStop(
            addressName = "TEATRO, 99",
            stopNumber = 99,
            isSavedInDb = true
        )

        coEvery {
            busStopsRepository.deleteBusStop(busStop)
        } returns Unit

        saveOrDeleteBusStopUseCase(busStop)

        coVerify(exactly = 1) {
            busStopsRepository.deleteBusStop(busStop)
        }
        coVerify(exactly = 0) {
            busStopsRepository.saveStops(busStop)
        }
    }
}
