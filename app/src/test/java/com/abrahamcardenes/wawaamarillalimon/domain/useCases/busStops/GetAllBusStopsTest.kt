package com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops

import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.domain.repositories.BusStopsRepository
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
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
    fun `When there is not local bus stops it should return bus stops with not repeated stops and sorted by stopNumber`() = runTest {
        val expected =
            Result.Success(
                listOf(
                    BusStop(
                        addressName = "TEATRO",
                        stopNumber = 1,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "C / FRANCISCO GOURIÉ, 103",
                        stopNumber = 2,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        isSavedInDb = false
                    )
                )
            )

        coEvery {
            repository.getAllLocalBusStops()
        } returns flow { emit(emptyList()) }

        coEvery {
            repository.getBusStops()
        } returns
            Result.Success(
                listOf(
                    BusStop(
                        addressName = "TEATRO",
                        stopNumber = 1,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "C / FRANCISCO GOURIÉ, 103",
                        stopNumber = 2,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "TEATRO",
                        stopNumber = 1,
                        isSavedInDb = false
                    )
                )
            )

        assertThat(getAllBusStopsUseCase().single()).isEqualTo(expected)
    }

    @Test
    fun `When there is local bus stops it should return bus stops with not repeated stops and sorted by stopNumber and saved to true`() =
        runTest {
            val expected =
                Result.Success(
                    listOf(
                        BusStop(
                            addressName = "TEATRO",
                            stopNumber = 1,
                            isSavedInDb = false
                        ),
                        BusStop(
                            addressName = "C / FRANCISCO GOURIÉ, 103",
                            stopNumber = 2,
                            isSavedInDb = false
                        ),
                        BusStop(
                            addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                            stopNumber = 79,
                            isSavedInDb = true
                        )
                    )
                )

            coEvery {
                repository.getAllLocalBusStops()
            } returns flow {
                emit(
                    listOf(
                        BusStop(
                            addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                            stopNumber = 79,
                            isSavedInDb = true
                        )
                    )
                )
            }

            coEvery {
                repository.getBusStops()
            } returns Result.Success(
                listOf(
                    BusStop(
                        addressName = "TEATRO",
                        stopNumber = 1,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "C / FRANCISCO GOURIÉ, 103",
                        stopNumber = 2,
                        isSavedInDb = false
                    ),
                    BusStop(
                        addressName = "TEATRO",
                        stopNumber = 1,
                        isSavedInDb = false
                    )
                )
            )

            assertThat(getAllBusStopsUseCase().single()).isEqualTo(expected)
        }
}
