package com.abrahamcardenes.lpa_presentation.destinations.home

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetAllBusStops
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetBusDetailUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetFavoriteBusStopsUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.SaveOrDeleteBusStopUseCase
import com.abrahamcardenes.lpa_presentation.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.lpa_presentation.fakes.TestsDispatchers
import com.abrahamcardenes.lpa_presentation.fakes.fakeBusStopDetail
import com.abrahamcardenes.lpa_presentation.fakes.fakeListBusStopDetail
import com.abrahamcardenes.lpa_presentation.fakes.fakeListBusStopDetailOffline
import com.abrahamcardenes.lpa_presentation.fakes.fakeListUiBusStopDetail
import com.abrahamcardenes.lpa_presentation.fakes.fakeListUiBusStopDetailOffline
import com.abrahamcardenes.lpa_presentation.home.BusStopTabs
import com.abrahamcardenes.lpa_presentation.home.BusStopsViewModel
import com.abrahamcardenes.lpa_presentation.home.enums.BusStopOrigin
import com.abrahamcardenes.lpa_presentation.home.states.BusStopState
import com.abrahamcardenes.lpa_presentation.mappers.toUiStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.mappers.toBusStop
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BusStopsViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val getAllBusStopsUseCase = mockk<GetAllBusStops>()
    private val getBusDetailUseCase = mockk<GetBusDetailUseCase>()
    private val saveOrDeleteBusStopUseCase = mockk<SaveOrDeleteBusStopUseCase>()
    private val getFavoriteBusStopsUseCase = mockk<GetFavoriteBusStopsUseCase>()

    private val crashlyticsService = mockk<CrashlyticsService>(relaxed = true)
    private lateinit var busStopsViewModel: BusStopsViewModel
    private val dispatchers = TestsDispatchers

    @Before
    fun setup() {
        busStopsViewModel = BusStopsViewModel(
            getAllBusStopsUseCase = getAllBusStopsUseCase,
            getBusDetailUseCase = getBusDetailUseCase,
            saveOrDeleteBusStopUseCase = saveOrDeleteBusStopUseCase,
            getFavoriteBusStopsUseCase = getFavoriteBusStopsUseCase,
            crashlyticsService = crashlyticsService,
            dispatchers = dispatchers
        )

        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetailOffline())
        }
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    private fun useCasesMocksToTestDetails() {
        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                Result.Success(fakeListBusStopDetail())
            )
        }
    }

    private fun firstGetDetailSetup(): Pair<Result<List<BusStop>, DataError>, List<UiBusStopDetail>> {
        val emissionExpected = Result.Success(fakeListBusStopDetail())
        val expectedList = fakeListUiBusStopDetail(isExpanded = true, lines = fakeBusStopDetail().availableBusLines)
        return Pair(emissionExpected, expectedList)
    }

    private fun firstGetDetailSetupOffline(): Pair<List<BusStop>, List<UiBusStopDetail>> {
        val emissionExpected = fakeListBusStopDetailOffline()
        val expectedList = fakeListUiBusStopDetailOffline(
            isExpanded = true,
            lines = fakeBusStopDetail().availableBusLines
        )
        return Pair(emissionExpected, expectedList)
    }

    @Test
    fun `When starting viewModel it should be loading and no busStops`() = runTest {
        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(emptyList())
        }

        assertThat(busStopsViewModel.onlineBusStopsState.value.selectedTab).isEqualTo(BusStopTabs.All)
        assertThat(busStopsViewModel.onlineBusStopsState.value.state).isEqualTo(BusStopState.Loading)
        assertThat(busStopsViewModel.onlineBusStopsState.value.busStops).isEmpty()
        assertThat(busStopsViewModel.favoriteBusStopsUiState.value.busStops).isEmpty()
        assertThat(busStopsViewModel.favoriteBusStopsUiState.value.isLoading).isTrue()
    }

    @Test
    fun `Given getAllBusStops and favoritesUseCase emits data and Then it should update both states`() = runTest {
        val listToEmit = fakeListBusStopDetail()
        val expected = listToEmit.toUiStopDetail()

        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                Result.Success(fakeListBusStopDetail())
            )
        }

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            assertThat(itemProduced.busStops).isEqualTo(expected)
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(fakeListBusStopDetailOffline().toUiStopDetail())
        }
    }

    @Test
    fun `When getAllBusStops emits data error it should show error state`() = runTest {
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                Result.Error(DataError.Remote.ServerFailure)
            )
        }

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Error)
            assertThat(itemProduced.busStops).isEmpty()
        }
    }

    @Test
    fun `When user inputs some text it should return only the ones that contains that text`() = runTest {
        val expected = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            )
        )

        val expectedOflline = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = null
            )
        )

        val listToEmit = Result.Success(fakeListBusStopDetail())
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        busStopsViewModel.updateUserInput("PASEO DE SAN")

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            assertThat(itemProduced.userInput).isEqualTo("PASEO DE SAN")
            assertThat(itemProduced.busStops).isEqualTo(
                expected
            )
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                expectedOflline
            )
        }
    }

    @Test
    fun `When user inputs some text and there is not matches it should return empty`() = runTest {
        val listToEmit = Result.Success(fakeListBusStopDetail())
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        busStopsViewModel.updateUserInput("Some random text")
        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            assertThat(itemProduced.userInput).isEqualTo("Some random text")
            assertThat(itemProduced.busStops).isEmpty()
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEmpty()
        }
    }

    @Test
    fun `When user inputs is the number of the bus stop it should return that bus stop`() = runTest {
        val expected = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            )
        )

        val expectedOffline = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = null
            )
        )

        val listToEmit = Result.Success(fakeListBusStopDetail())
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        busStopsViewModel.updateUserInput("79")

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            assertThat(itemProduced.userInput).isEqualTo("79")
            assertThat(itemProduced.busStops).isEqualTo(
                expected
            )
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                expectedOffline
            )
        }
    }

    @Test
    fun `When user save into favorites it should be saved`() = runTest {
        val savedBusStop = MutableStateFlow<BusStop?>(null)
        val emissionExpected = Result.Success(fakeListBusStopDetail(setFirstToFavorite = true)).onSuccess {
            it
        }

        coEvery {
            saveOrDeleteBusStopUseCase(
                BusStop(
                    addressName = "TEATRO",
                    stopNumber = 1,
                    isFavorite = false
                )
            )
        } returns Unit

        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                Result.Success(fakeListBusStopDetail())
            )
            savedBusStop.collect {
                if (savedBusStop.value != null) {
                    emit(Result.Success(fakeListBusStopDetail(setFirstToFavorite = true)))
                }
            }
        }

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(fakeListBusStopDetail().toUiStopDetail())
            }
            savedBusStop.value = fakeListBusStopDetail().toUiStopDetail().first().toBusStop()
            busStopsViewModel.saveOrDeleteBusStop(fakeListBusStopDetail().toUiStopDetail().first())
            val secondEmission = awaitItem()
            emissionExpected.onSuccess {
                assertThat(secondEmission.busStops).isEqualTo(
                    it.toUiStopDetail()
                )
            }
        }

        coVerify(exactly = 1) {
            saveOrDeleteBusStopUseCase(fakeListBusStopDetail().toUiStopDetail().first().toBusStop())
        }
    }

    @Test
    fun `When user expands an Online bus stop Then it should be set as expanded`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetup()

        useCasesMocksToTestDetails()

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(it.toUiStopDetail())
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user expands a Favorite card bus stop it should be set as expanded`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetupOffline()

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                emissionExpected.toUiStopDetail()
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user collapse a Favorite card bus stop it should be set as not expanded`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetupOffline()

        val expectedCollapsedList = fakeListUiBusStopDetailOffline(
            lines = listOf(
                BusLine(
                    number = "13",
                    destination = "TRESPALMAS",
                    arrivalTimeIn = "15min"
                )
            )
        )
        useCasesMocksToTestDetails()

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                emissionExpected.toUiStopDetail()
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterCollapsing = awaitItem()
            assertThat(itemProducedAfterCollapsing.busStops).isEqualTo(
                expectedCollapsedList
            )
            assertThat(itemProducedAfterCollapsing.currentExpandedBusStop).isNull()
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When fetching details for a bus stop fails it should show the empty list with the bus stop expanded`() = runTest {
        val (emissionExpected, _) = firstGetDetailSetup()

        val expected = fakeListUiBusStopDetail(isExpanded = true, lines = emptyList())

        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                Result.Success(fakeListBusStopDetail())
            )
        }

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Error(DataError.Remote.ServerFailure)
            )
        }

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(it.toUiStopDetail())
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(expected)

            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expected.find { it.stopNumber == 79 }
            )
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user collapse a card bus stop it should be set as not expanded`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetup()
        val expectedCollapsedList = fakeListUiBusStopDetail(
            lines = listOf(
                BusLine(
                    number = "13",
                    destination = "TRESPALMAS",
                    arrivalTimeIn = "15min"
                )
            )
        )
        useCasesMocksToTestDetails()

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)

            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(it.toUiStopDetail())
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterCollapsing = awaitItem()
            assertThat(itemProducedAfterCollapsing.busStops).isEqualTo(
                expectedCollapsedList
            )
            assertThat(itemProducedAfterCollapsing.currentExpandedBusStop).isNull()
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user selects a different Online card it should collapse the old one and expand the new`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetup()
        val expectedUpdatedList = listOf(
            UiBusStopDetail(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = false,
                isExpanded = true,
                availableBusLines = emptyList()
            ),
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = listOf(
                    BusLine(
                        number = "13",
                        destination = "TRESPALMAS",
                        arrivalTimeIn = "15min"
                    )
                )
            ),
            UiBusStopDetail(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            )
        )

        useCasesMocksToTestDetails()

        coEvery {
            getBusDetailUseCase(stopNumber = 1)
        } returns flow {
            emit(
                Result.Success(
                    BusStopDetail(
                        addressName = "TEATRO",
                        availableBusLines = emptyList()
                    )
                )
            )
        }

        busStopsViewModel.onlineBusStopsState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.state).isEqualTo(BusStopState.Success)
            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(
                    it.toUiStopDetail()
                )
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 1, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterCollapsing = awaitItem()
            assertThat(itemProducedAfterCollapsing.busStops).isEqualTo(
                expectedUpdatedList
            )
            assertThat(itemProducedAfterCollapsing.currentExpandedBusStop).isEqualTo(
                expectedUpdatedList.find { it.stopNumber == 1 }
            )
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
            getBusDetailUseCase(stopNumber = 1)
        }
    }

    @Test
    fun `When user selects a different Favorite card it should collapse the old one and expand the new`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetupOffline()
        val expectedUpdatedList = listOf(
            UiBusStopDetail(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = true,
                isExpanded = true,
                availableBusLines = emptyList()
            ),
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = listOf(
                    BusLine(
                        number = "13",
                        destination = "TRESPALMAS",
                        arrivalTimeIn = "15min"
                    )
                )
            ),
            UiBusStopDetail(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = null
            )
        )

        useCasesMocksToTestDetails()

        coEvery {
            getBusDetailUseCase(stopNumber = 1)
        } returns flow {
            emit(
                Result.Success(
                    BusStopDetail(
                        addressName = "TEATRO",
                        availableBusLines = emptyList()
                    )
                )
            )
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                emissionExpected.toUiStopDetail()
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 1, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterCollapsing = awaitItem()
            assertThat(itemProducedAfterCollapsing.busStops).isEqualTo(
                expectedUpdatedList
            )
            assertThat(itemProducedAfterCollapsing.currentExpandedBusStop).isEqualTo(
                expectedUpdatedList.find { it.stopNumber == 1 }
            )
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
            getBusDetailUseCase(stopNumber = 1)
        }
    }

    @Test
    fun `When a card is expanded and getAllBusStops emits again it should keep the current set as expanded`() = runTest {
        val (_, expectedList) = firstGetDetailSetup()
        val emitAgain = MutableStateFlow<Boolean>(false)

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                Result.Success(
                    fakeListBusStopDetail()
                )
            )
            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)
            emitAgain.collect {
                if (it) {
                    emit(
                        Result.Success(
                            fakeListBusStopDetail().toMutableList().apply {
                                add(
                                    BusStop(
                                        addressName = "LEÓN Y CASTILLO, 13",
                                        stopNumber = 6,
                                        isFavorite = false
                                    )
                                )
                            }
                        )
                    )
                }
            }
        }

        busStopsViewModel.onlineBusStopsState.test {
            val itemProducedAfterExpansion = awaitItem()
            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            emitAgain.update {
                true
            }
            val itemProducedAfterSecondGetAllEmission = awaitItem()

            assertThat(itemProducedAfterSecondGetAllEmission.busStops).isEqualTo(
                fakeListUiBusStopDetail(isExpanded = true, lines = fakeBusStopDetail().availableBusLines).toMutableList().apply {
                    add(
                        UiBusStopDetail(
                            addressName = "LEÓN Y CASTILLO, 13",
                            stopNumber = 6,
                            isFavorite = false,
                            isExpanded = false,
                            availableBusLines = null
                        )
                    )
                }
            )

            assertThat(itemProducedAfterSecondGetAllEmission.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user calls delete bus stop it should not be available in the busStops list`() = runTest {
        val deletedStop = MutableStateFlow<BusStop?>(null)

        val expected = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = true
            ),
            BusStop(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = true
            )
        )
        coEvery {
            saveOrDeleteBusStopUseCase(
                BusStop(
                    addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                    stopNumber = 79,
                    isFavorite = true
                )
            )
        } returns Unit

        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(
                fakeListBusStopDetailOffline()
            )
            deletedStop.collect { deletedBusStop ->
                if (deletedBusStop != null) {
                    val updatedList =
                        fakeListBusStopDetailOffline().filterNot { it.stopNumber == deletedBusStop.stopNumber }
                    emit(updatedList) // Emit updated list only when a stop is deleted
                }
            }
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.busStops).isEqualTo(
                fakeListBusStopDetailOffline().toUiStopDetail()
            )

            deletedStop.value = fakeListBusStopDetailOffline()[1]
            busStopsViewModel.saveOrDeleteBusStop(
                busStopUiBusStopDetail = fakeListBusStopDetailOffline().toUiStopDetail()[1]
            )
            val itemProducedAfterDelete = awaitItem()
            assertThat(itemProducedAfterDelete.busStops).isEqualTo(
                expected.toUiStopDetail()
            )
        }

        coVerify(exactly = 1) {
            saveOrDeleteBusStopUseCase(
                BusStop(
                    addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                    stopNumber = 79,
                    isFavorite = true
                )
            )
        }
    }

    @Test
    fun `Given an open card online When user switches to Favorite tab it should collapse the card`() = runTest {
        val expectedList = fakeListUiBusStopDetail(isExpanded = false, lines = fakeBusStopDetail().availableBusLines)
        useCasesMocksToTestDetails()

        busStopsViewModel.onlineBusStopsState.test {
            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)
            skipItems(2)
            busStopsViewModel.onTabClick(busStopTab = BusStopTabs.Favorites)

            val itemAfterSwitchingTab = awaitItem()
            assertThat(itemAfterSwitchingTab.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemAfterSwitchingTab.currentExpandedBusStop).isNull()

            val emissionTabChanged = awaitItem()
            assertThat(emissionTabChanged.selectedTab).isEqualTo(
                BusStopTabs.Favorites
            )
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `Given an open card Favorite When user switches to Online tab it should collapse the card`() = runTest {
        val (emissionExpected, expectedListOffline) = firstGetDetailSetupOffline()

        useCasesMocksToTestDetails()

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }

        busStopsViewModel.onlineBusStopsState.test {
            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)
            busStopsViewModel.onTabClick(busStopTab = BusStopTabs.Favorites)
            skipItems(3)

            val emissionTabChanged = awaitItem()
            assertThat(emissionTabChanged.selectedTab).isEqualTo(
                BusStopTabs.Favorites
            )
        }

        busStopsViewModel.favoriteBusStopsUiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                emissionExpected.toUiStopDetail()
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedListOffline
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedListOffline.find { it.stopNumber == 79 }
            )

            busStopsViewModel.onTabClick(busStopTab = BusStopTabs.All)

            val itemAfterSwitchingTab = awaitItem()
            assertThat(itemAfterSwitchingTab.busStops).isEqualTo(
                fakeListUiBusStopDetailOffline(
                    isExpanded = false,
                    lines = fakeBusStopDetail().availableBusLines
                )
            )
            assertThat(itemAfterSwitchingTab.currentExpandedBusStop).isNull()
        }
        busStopsViewModel.onlineBusStopsState.test {
            val emissionTabChanged = awaitItem()
            assertThat(emissionTabChanged.selectedTab).isEqualTo(
                BusStopTabs.All
            )
        }

        coVerify(exactly = 2) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }
}
