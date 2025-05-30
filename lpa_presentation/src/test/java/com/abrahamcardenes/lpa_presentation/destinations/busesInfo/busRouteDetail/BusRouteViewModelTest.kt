package com.abrahamcardenes.lpa_presentation.destinations.busesInfo.busRouteDetail

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.core.GpsCoordinates
import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.lpa_domain.useCases.concessions.GetBusRouteUseCase
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.BusRouteState
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.BusRouteUiState
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.BusRouteViewModel
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels.ScheduleUi
import com.abrahamcardenes.lpa_presentation.busesInfo.busRouteDetail.uiModels.TimeUi
import com.abrahamcardenes.lpa_presentation.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.lpa_presentation.fakes.backStopsTypeBD
import com.abrahamcardenes.lpa_presentation.fakes.busRouteFake
import com.abrahamcardenes.lpa_presentation.fakes.goStopsTypeA
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
    private val crashlyticsService = mockk<CrashlyticsService>(relaxed = true)

    @Before
    fun setup() {
        busRouteViewModel = BusRouteViewModel(
            getBusRouteUseCase = getBusRouteUseCase,
            crashlyticsService = crashlyticsService
        )
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

        busRouteViewModel.busSchedules.test {
            assertThat(awaitItem()).isEmpty()
        }
    }

    @Test
    fun `Given a call to getBusRoute it should update the uiState and the available stops`() = runTest {
        coEvery {
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = "50")

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.state).isEqualTo(BusRouteState.Success)
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
    fun `When the call to getBusRoute fails it should update the uiState to error`() = runTest {
        coEvery {
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Error(DataError.Remote.ServerFailure)

        busRouteViewModel.getBusRoute(busIdNumber = "50")

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.state).isEqualTo(BusRouteState.Error)
            assertThat(firstEmission.busRoute).isNull()
        }

        busRouteViewModel.availableRouteStops.test {
            assertThat(awaitItem()).isEmpty()
        }

        busRouteViewModel.availableBackRouteStops.test {
            assertThat(awaitItem()).isEqualTo(emptyList<RouteStop>())
        }
    }

    @Test
    fun `Given the user selecting a tab it should update the uiState`() = runTest {
        coEvery {
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = "50")
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
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Success(busRouteFake())

        busRouteViewModel.getBusRoute(busIdNumber = "50")
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
    fun `Given a bus route, selecting an index and variant WHEN returning to index zero, resets uiState and clears the selected variant`() = runTest {
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
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = "50")
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

    @Test
    fun `When the user clicks on the schedule button it should update the uiState`() = runTest {
        busRouteViewModel.openOrCloseScheduleDialog()
        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.showDialog).isTrue()
        }
        assertThat(busRouteViewModel.uiState.value.showDialog).isTrue()

        busRouteViewModel.openOrCloseScheduleDialog()
        busRouteViewModel.uiState.test {
            val secondEmission = awaitItem()
            assertThat(secondEmission.showDialog).isFalse()
        }
    }

    @Test
    fun `Given a bus route it should show the correct time table WHEN index = 0`() = runTest {
        val expectedScheduleUi = listOf(
            ScheduleUi(
                node = "Ciudad Deportiva Gran Canaria",
                typology = "De lunes a viernes",
                time = listOf(
                    TimeUi(
                        time = "06:55",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        )
                    ),
                    TimeUi(
                        time = "7:30",
                        color = RGBAColor(
                            red = 0,
                            green = 0,
                            blue = 0,
                            alpha = 1
                        )
                    )
                )
            ),
            ScheduleUi(
                node = "Ciudad Deportiva Gran Canaria",
                typology = "Sábado",
                time = listOf(
                    TimeUi(
                        time = "08:05",
                        color = RGBAColor(
                            red = 0,
                            green = 0,
                            blue = 0,
                            alpha = 0
                        )
                    )
                )
            ),
            ScheduleUi(
                node = "Ciudad Deportiva Gran Canaria",
                typology = "Domingo y festivo",
                time = listOf(
                    TimeUi(
                        time = "07:50",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        )
                    )
                )
            )
        )

        coEvery {
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = "50")

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.selectedVariant).isNull()
            assertThat(firstEmission.selectedIndex).isEqualTo(0)
            assertThat(firstEmission.busRoute).isEqualTo(busRouteFake())
        }

        busRouteViewModel.busSchedules.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission).isEqualTo(expectedScheduleUi)
        }
    }

    @Test
    fun `Given a bus route it should show the correct time table WHEN index = 1`() = runTest {
        val expectedScheduleUi = listOf(
            ScheduleUi(
                node = "Zárate",
                typology = "De lunes a viernes",
                time = listOf(
                    TimeUi(
                        time = "06:10",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        )
                    )
                )
            ),
            ScheduleUi(
                node = "Zárate",
                typology = "Sábado",
                time = listOf(
                    TimeUi(
                        time = "07:10",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        ),
                        variant = "D"
                    )
                )
            ),
            ScheduleUi(
                node = "Zárate",
                typology = "Domingo y festivo",
                time = listOf(
                    TimeUi(
                        time = "08:35",
                        color = RGBAColor(
                            red = 231,
                            green = 157,
                            blue = 214,
                            alpha = 1
                        ),
                        variant = "D"
                    ),
                    TimeUi(
                        time = "10:20",
                        color = RGBAColor(
                            red = 0,
                            green = 0,
                            blue = 0,
                            alpha = 0
                        )
                    )
                )
            )
        )

        coEvery {
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = "50")
        busRouteViewModel.onIndexSelection(value = 1)

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.selectedVariant).isNull()
            assertThat(firstEmission.selectedIndex).isEqualTo(1)
            assertThat(firstEmission.busRoute).isEqualTo(busRouteFake())
        }

        busRouteViewModel.busSchedules.test {
            val firstEmission = awaitItem()
            println(firstEmission)
            assertThat(firstEmission).isEqualTo(expectedScheduleUi)
        }
    }

    @Test
    fun `Given a bus route it should show the correct time table WHEN index = 1 AND selected variant is NOT null`() = runTest {
        val expectedScheduleUi = listOf(
            ScheduleUi(
                node = "Zárate",
                typology = "De lunes a viernes",
                time = listOf(
                    TimeUi(
                        time = "06:10",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        )
                    )
                )
            ),
            ScheduleUi(
                node = "Zárate",
                typology = "Domingo y festivo",
                time = listOf(
                    TimeUi(
                        time = "10:20",
                        color = RGBAColor(
                            red = 0,
                            green = 0,
                            blue = 0,
                            alpha = 0
                        )
                    )
                )
            )
        )
        val expectedSelectedVariant = Variants(
            type = "B",
            name = "Zárate - Ciudad Deportiva Gran Canaria",
            color = RGBAColor(
                red = 231,
                green = 157,
                blue = 214,
                alpha = 1
            )
        )
        coEvery {
            getBusRouteUseCase(concessionId = "50")
        } returns Result.Success(busRouteFake())
        busRouteViewModel.getBusRoute(busIdNumber = "50")
        busRouteViewModel.onIndexSelection(value = 1)
        busRouteViewModel.onRouteSelection(variant = expectedSelectedVariant)

        busRouteViewModel.uiState.test {
            val firstEmission = awaitItem()
            assertThat(firstEmission.selectedVariant).isEqualTo(expectedSelectedVariant)
            assertThat(firstEmission.selectedIndex).isEqualTo(1)
            assertThat(firstEmission.busRoute).isEqualTo(busRouteFake())
        }

        busRouteViewModel.busSchedules.test {
            val scheduledUiItems = awaitItem()
            println(scheduledUiItems)
            assertThat(scheduledUiItems).isEqualTo(expectedScheduleUi)
        }
    }
}
