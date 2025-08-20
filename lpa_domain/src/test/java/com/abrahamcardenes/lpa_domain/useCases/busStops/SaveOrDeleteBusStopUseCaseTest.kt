package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsEvents
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsParams
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
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
    private val analyticsService = mockk<AnalyticsService>()
    private lateinit var saveOrDeleteBusStopUseCase: SaveOrDeleteBusStopUseCase

    @Before
    fun setup() {
        saveOrDeleteBusStopUseCase = SaveOrDeleteBusStopUseCase(
            busStopsRepository = busStopsRepository,
            analyticsService = analyticsService
        )
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

        coEvery {
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.FAVORITE_CLICKED,
                params =
                arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
        } returns Unit

        saveOrDeleteBusStopUseCase(busStop)

        coVerify(exactly = 1) {
            busStopsRepository.saveStops(busStop)
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.FAVORITE_CLICKED,
                params =
                arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
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

        coEvery {
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.UNFAVORITE_CLICKED,
                params =
                arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
        } returns Unit

        saveOrDeleteBusStopUseCase(busStop)

        coVerify(exactly = 1) {
            busStopsRepository.deleteBusStop(busStop)
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.UNFAVORITE_CLICKED,
                params =
                arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
        }
        coVerify(exactly = 0) {
            busStopsRepository.saveStops(busStop)
        }
    }
}
