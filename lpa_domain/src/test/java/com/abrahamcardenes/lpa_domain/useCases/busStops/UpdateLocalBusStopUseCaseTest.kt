package com.abrahamcardenes.lpa_domain.useCases.busStops

import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsEvents
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsParams
import com.abrahamcardenes.core_android.firebase.analytics.AnalyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class UpdateLocalBusStopUseCaseTest {
    private val busStopsRepository = mockk<BusStopsRepository>()
    private val analyticsService = mockk<AnalyticsService>()
    private lateinit var updateLocalBusStopUseCase: UpdateLocalBusStopUseCase

    @Before
    fun setup() {
        updateLocalBusStopUseCase = UpdateLocalBusStopUseCase(
            busStopsRepository = busStopsRepository,
            analyticsService = analyticsService
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given a call to updateLocalBusStop When the stop IS NOT favorite then it should send favorite log and call db with favorite to true value`() = runTest {
        val busStop = BusStop(
            addressName = "TEATRO, 99",
            stopNumber = 99,
            isFavorite = true
        )

        coEvery {
            busStopsRepository.updateBusStopInDb(busStop)
        } returns Unit

        coEvery {
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.FAVORITE_CLICKED,
                params = arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
        } returns Unit

        updateLocalBusStopUseCase(busStop.copy(isFavorite = false))

        coVerifySequence {
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.FAVORITE_CLICKED,
                params = arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
            busStopsRepository.updateBusStopInDb(busStop)
        }
    }

    @Test
    fun `Given a call to updateLocalBusStop When the stop IS favorite then it should send unfavorite log and call db with favorite to false value`() = runTest {
        val busStop = BusStop(
            addressName = "TEATRO, 99",
            stopNumber = 99,
            isFavorite = false
        )

        coEvery {
            busStopsRepository.updateBusStopInDb(busStop)
        } returns Unit

        coEvery {
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.UNFAVORITE_CLICKED,
                params = arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
        } returns Unit

        updateLocalBusStopUseCase(busStop.copy(isFavorite = true))

        coVerifySequence {
            analyticsService.sendLogEvent(
                event = AnalyticsEvents.UNFAVORITE_CLICKED,
                params = arrayOf(
                    Pair(AnalyticsParams.STOP_NUMBER, busStop.stopNumber),
                    Pair(AnalyticsParams.STOP_NAME, busStop.addressName)
                )
            )
            busStopsRepository.updateBusStopInDb(busStop)
        }
    }
}
