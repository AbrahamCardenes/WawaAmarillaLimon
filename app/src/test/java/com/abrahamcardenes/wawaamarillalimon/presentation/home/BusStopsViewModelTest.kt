package com.abrahamcardenes.wawaamarillalimon.presentation.home

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.wawaamarillalimon.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busStops.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops.GetAllBusStops
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops.GetBusDetailUseCase
import com.abrahamcardenes.wawaamarillalimon.domain.useCases.busStops.SaveOrDeleteBusStopUseCase
import com.abrahamcardenes.wawaamarillalimon.fakes.fakeBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.fakes.fakeListBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.fakes.fakeListUiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.mappers.toUiStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.UiBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.presentation.uiModels.mappers.toBusStop
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
    private lateinit var busStopsViewModel: BusStopsViewModel

    @Before
    fun setup() {
        busStopsViewModel = BusStopsViewModel(
            getAllBusStopsUseCase = getAllBusStopsUseCase,
            getBusDetailUseCase = getBusDetailUseCase,
            saveOrDeleteBusStopUseCase = saveOrDeleteBusStopUseCase
        )
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

    @Test
    fun `When starting viewModel it should be loading and no busStops`() = runTest {
        assertThat(busStopsViewModel.uiState.value.isLoading).isTrue()
        assertThat(busStopsViewModel.uiState.value.busStops).isEmpty()
    }

    @Test
    fun `When getAllBusStops emits it should stop loading and show busStops`() = runTest {
        val listToEmit = fakeListBusStopDetail()
        val expected = listToEmit.toUiStopDetail()

        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                Result.Success(fakeListBusStopDetail())
            )
        }

        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(expected)
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
        val listToEmit = Result.Success(fakeListBusStopDetail())
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        busStopsViewModel.updateUserInput("PASEO DE SAN")

        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.userInput).isEqualTo("PASEO DE SAN")
            assertThat(itemProduced.busStops).isEqualTo(
                expected
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
        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.userInput).isEqualTo("Some random text")
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
        val listToEmit = Result.Success(fakeListBusStopDetail())
        coEvery {
            getAllBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        busStopsViewModel.updateUserInput("79")

        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.userInput).isEqualTo("79")
            assertThat(itemProduced.busStops).isEqualTo(
                expected
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
                    isSavedInDb = false
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

        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
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
    fun `When user expands a card bus stop it should be set as expanded`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetup()

        useCasesMocksToTestDetails()

        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(it.toUiStopDetail())
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79)

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

        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()

            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(it.toUiStopDetail())
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 79)

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
    fun `When user selects a different card it should collapse the old one and expand the new`() = runTest {
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

        busStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            emissionExpected.onSuccess {
                assertThat(itemProduced.busStops).isEqualTo(
                    it.toUiStopDetail()
                )
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            busStopsViewModel.getBusStopDetail(stopNumber = 1)

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
            busStopsViewModel.getBusStopDetail(stopNumber = 79)
            emitAgain.collect {
                if (it) {
                    emit(
                        Result.Success(
                            fakeListBusStopDetail().toMutableList().apply {
                                add(
                                    BusStop(
                                        addressName = "LEÓN Y CASTILLO, 13",
                                        stopNumber = 6,
                                        isSavedInDb = false
                                    )
                                )
                            }
                        )
                    )
                }
            }
        }

        busStopsViewModel.uiState.test {
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
}
