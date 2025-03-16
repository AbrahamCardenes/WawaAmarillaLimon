package com.abrahamcardenes.wawaamarillalimon.presentation.travellers.busRouteDetail

import app.cash.turbine.test
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.Variants
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.GpsCoordinates
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.RGBAColor
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.travellers.GetBusRouteUseCase
import com.abrahamcardenes.wawaamarillalimon.fakes.backStopsTypeBD
import com.abrahamcardenes.wawaamarillalimon.fakes.busRouteFake
import com.abrahamcardenes.wawaamarillalimon.fakes.goStopsTypeA
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

class BusRouteViewModelTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var busRouteViewModel: BusRouteViewModel
    private val getBusRouteUseCase = mockk<GetBusRouteUseCase>(relaxed = true)

    @Before
    fun setup() {
        busRouteViewModel = BusRouteViewModel(getBusRouteUseCase = getBusRouteUseCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given an initial state it should be loading and with empty items`() = runTest {
        assertThat(busRouteViewModel.uiState.value).isEqualTo(BusRouteUiState())
        busRouteViewModel.availableRouteStops.test {
            assertThat(awaitItem()).isEmpty()
        }
        busRouteViewModel.availableBackRouteStops.test {
            assertThat(awaitItem()).isEmpty()
        }
    }

    @Test
    fun `Given a call to getBusRoute it should update the uiState and the available stops`() = runTest {
        coEvery {
            getBusRouteUseCase(busIdNumber = 50)
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = 50)

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.isLoading).isFalse()
            assertThat(firstEmission.busRoute).isEqualTo(busRouteFake())
        }

        busRouteViewModel.availableRouteStops.test {
            assertThat(awaitItem()).isEqualTo(goStopsTypeA())
        }

        busRouteViewModel.availableBackRouteStops.test {
            assertThat(awaitItem()).isEqualTo(emptyList<RouteStop>())
        }
    }

    @Test
    fun `Given the user selecting a tab it should update the uiState`() = runTest {
        coEvery {
            getBusRouteUseCase(busIdNumber = 50)
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = 50)
        busRouteViewModel.onIndexSelection(value = 1)

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.selectedVariant).isNull()
            assertThat(firstEmission.selectedIndex).isEqualTo(1)
            assertThat(firstEmission.busRoute).isEqualTo(busRouteFake())
        }
    }

    @Test
    fun `Given a bus route WHEN user selects an index and variant it should update the uiState and the available stops`() = runTest {
        val expectedSelectedVariant = Variants(
            type = "D",
            name = "Estas expediciones no circulan por Francisco Inglott Artiles",
            color = RGBAColor(
                red = 231,
                green = 157,
                blue = 214,
                alpha = 1
            )
        )

        coEvery {
            getBusRouteUseCase(busIdNumber = 50)
        } returns Result.Success(busRouteFake())

        busRouteViewModel.getBusRoute(busIdNumber = 50)
        busRouteViewModel.onIndexSelection(value = 1)

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.selectedVariant).isNull()
            assertThat(firstEmission.selectedIndex).isEqualTo(1)
            assertThat(firstEmission.busRoute).isEqualTo(busRouteFake())
        }

        busRouteViewModel.availableRouteStops.test {
            assertThat(awaitItem()).isEqualTo(emptyList<RouteStop>())
        }

        busRouteViewModel.availableBackRouteStops.test {
            assertThat(awaitItem()).isEqualTo(
                backStopsTypeBD()
            )
        }

        busRouteViewModel.onRouteSelection(
            variant = expectedSelectedVariant
        )

        busRouteViewModel.uiState.test {
            val secondEmission = awaitItem()
            assertThat(secondEmission.selectedVariant).isEqualTo(expectedSelectedVariant)
        }

        busRouteViewModel.availableRouteStops.test {
            assertThat(awaitItem()).isEqualTo(emptyList<RouteStop>())
        }

        busRouteViewModel.availableBackRouteStops.test {
            assertThat(awaitItem()).isEqualTo(
                listOf(
                    RouteStop(
                        number = "970",
                        name = "Leonardo Torriani (Zárate)",
                        gpsCoordinates = GpsCoordinates(
                            longitude = -15.42227448,
                            latitude = 28.07906443
                        ),
                        node = "Zárate",
                        variants = listOf("B", "D")
                    )
                )
            )
        }
    }

    @Test
    fun `Given a bus route, selecting an index and variant WHEN returning to index zero, resets uiState and clears the selected variant`() =
        runTest {
            val expectedSelectedVariant = Variants(
                type = "D",
                name = "Estas expediciones no circulan por Francisco Inglott Artiles",
                color = RGBAColor(
                    red = 231,
                    green = 157,
                    blue = 214,
                    alpha = 1
                )
            )

            coEvery {
                getBusRouteUseCase(busIdNumber = 50)
            } returns Result.Success(busRouteFake())
            busRouteViewModel.getBusRoute(busIdNumber = 50)
            busRouteViewModel.onIndexSelection(value = 1)

            busRouteViewModel.uiState.test {
                val firstEmission = awaitItem()
                assertThat(firstEmission.selectedVariant).isNull()
                assertThat(firstEmission.selectedIndex).isEqualTo(1)
                assertThat(firstEmission.busRoute).isEqualTo(busRouteFake())
            }
            busRouteViewModel.availableRouteStops.test {
                assertThat(awaitItem()).isEqualTo(emptyList<RouteStop>())
            }
            busRouteViewModel.availableBackRouteStops.test {
                assertThat(awaitItem()).isEqualTo(backStopsTypeBD())
            }

            busRouteViewModel.onRouteSelection(variant = expectedSelectedVariant)

            busRouteViewModel.uiState.test {
                val secondEmission = awaitItem()
                assertThat(secondEmission.selectedVariant).isEqualTo(expectedSelectedVariant)
                assertThat(secondEmission.selectedIndex).isEqualTo(1)
            }
            busRouteViewModel.availableBackRouteStops.test {
                assertThat(awaitItem()).isEqualTo(
                    listOf(
                        RouteStop(
                            number = "970",
                            name = "Leonardo Torriani (Zárate)",
                            gpsCoordinates = GpsCoordinates(
                                longitude = -15.42227448,
                                latitude = 28.07906443
                            ),
                            node = "Zárate",
                            variants = listOf("B", "D")
                        )
                    )
                )
            }

            busRouteViewModel.onIndexSelection(value = 0)

            busRouteViewModel.uiState.test {
                val thirdEmission = awaitItem()
                assertThat(thirdEmission.selectedVariant).isEqualTo(null)
                assertThat(thirdEmission.selectedIndex).isEqualTo(0)
            }
            busRouteViewModel.availableRouteStops.test {
                assertThat(awaitItem()).isEqualTo(goStopsTypeA())
            }

            busRouteViewModel.availableBackRouteStops.test {
                assertThat(awaitItem()).isEqualTo(emptyList<RouteStop>())
            }
        }
}
