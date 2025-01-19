package com.abrahamcardenes.wawaamarillalimon.domain.useCases

import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetAllBusStopsTest {
    private val repository = mockk<BusStopsRepository>()
    private lateinit var getAllBusStopsUseCase: GetAllBusStops

    @Before
    fun setup() {
        getAllBusStopsUseCase = GetAllBusStops(repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given a call to repository it should return bus stops with not repeated stops and sorted by stopNumber`() =
        runTest {
            val expected = listOf(
                BusStop(
                    addressName = "TEATRO",
                    stopNumber = 1
                ),
                BusStop(
                    addressName = "C / FRANCISCO GOURIÉ, 103",
                    stopNumber = 2
                ),
                BusStop(
                    addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                    stopNumber = 79
                ),
            )

            coEvery {
                repository.getBusStops()
            } returns listOf(
                BusStop(
                    addressName = "TEATRO",
                    stopNumber = 1
                ),
                BusStop(
                    addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                    stopNumber = 79
                ),
                BusStop(
                    addressName = "C / FRANCISCO GOURIÉ, 103",
                    stopNumber = 2
                ),
                BusStop(
                    addressName = "TEATRO",
                    stopNumber = 1
                )
            )

            assertThat(getAllBusStopsUseCase()).isEqualTo(expected)
        }
}