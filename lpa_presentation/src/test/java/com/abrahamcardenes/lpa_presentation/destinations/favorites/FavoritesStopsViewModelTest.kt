package com.abrahamcardenes.lpa_presentation.destinations.favorites

import app.cash.turbine.test
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetBusDetailUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetFavoriteBusStopsUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.SaveOrDeleteBusStopUseCase
import com.abrahamcardenes.lpa_presentation.coroutineRules.MainCoroutineRule
import com.abrahamcardenes.lpa_presentation.fakes.fakeBusStopDetail
import com.abrahamcardenes.lpa_presentation.fakes.fakeListBusStopDetail
import com.abrahamcardenes.lpa_presentation.fakes.fakeListBusStopDetailOffline
import com.abrahamcardenes.lpa_presentation.fakes.fakeListUiBusStopDetail
import com.abrahamcardenes.lpa_presentation.fakes.fakeListUiBusStopDetailOffline
import com.abrahamcardenes.lpa_presentation.favorites.FavoritesStopsViewModel
import com.abrahamcardenes.lpa_presentation.mappers.toUiStopDetail
import com.abrahamcardenes.lpa_presentation.uiModels.UiBusStopDetail
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlin.collections.get
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
class FavoritesStopsViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var favoritesStopsViewModel: FavoritesStopsViewModel
    private lateinit var getFavoriteBusStopsUseCase: GetFavoriteBusStopsUseCase
    private lateinit var getBusDetailUseCase: GetBusDetailUseCase
    private lateinit var saveOrDeleteBusStopUseCase: SaveOrDeleteBusStopUseCase

    @Before
    fun setup() {
        getFavoriteBusStopsUseCase = mockk(relaxed = true)
        getBusDetailUseCase = mockk(relaxed = true)
        saveOrDeleteBusStopUseCase = mockk(relaxed = true)
        favoritesStopsViewModel = FavoritesStopsViewModel(
            getFavoriteBusStopsUseCase = getFavoriteBusStopsUseCase,
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
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(
                fakeListBusStopDetailOffline()
            )
        }
    }

    private fun firstGetDetailSetup(): Pair<List<BusStop>, List<UiBusStopDetail>> {
        val emissionExpected = fakeListBusStopDetailOffline()
        val expectedList = fakeListUiBusStopDetailOffline(
            isExpanded = true,
            lines = fakeBusStopDetail().availableBusLines
        )
        return Pair(emissionExpected, expectedList)
    }

    @Test
    fun `When starting viewModel it should be loading and no busStops`() = runTest {
        assertThat(favoritesStopsViewModel.uiState.value.isLoading).isTrue()
        assertThat(favoritesStopsViewModel.uiState.value.busStops).isEmpty()
    }

    @Test
    fun `When getAllBusStops emits it should stop loading and show busStops`() = runTest {
        val listToEmit = fakeListBusStopDetailOffline()
        val expected = listToEmit.toUiStopDetail()

        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        favoritesStopsViewModel.uiState.test {
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
                isFavorite = true,
                isExpanded = false,
                availableBusLines = null
            )
        )
        val listToEmit = fakeListBusStopDetailOffline()
        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        favoritesStopsViewModel.updateUserInput("PASEO DE SAN")

        favoritesStopsViewModel.uiState.test {
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
        val listToEmit = fakeListBusStopDetailOffline()
        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        favoritesStopsViewModel.updateUserInput("Some random text")
        favoritesStopsViewModel.uiState.test {
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
                isFavorite = true,
                isExpanded = false,
                availableBusLines = null
            )
        )
        val listToEmit = fakeListBusStopDetailOffline()
        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(
                listToEmit
            )
        }

        favoritesStopsViewModel.updateUserInput("79")

        favoritesStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.userInput).isEqualTo("79")
            assertThat(itemProduced.busStops).isEqualTo(
                expected
            )
        }
    }

    @Test
    fun `When user expands a card bus stop it should be set as expanded`() = runTest {
        val (emissionExpected, expectedList) = firstGetDetailSetup()

        useCasesMocksToTestDetails()

        favoritesStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                emissionExpected.toUiStopDetail()
            )

            favoritesStopsViewModel.getBusStopDetail(stopNumber = 79)

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

        favoritesStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                emissionExpected.toUiStopDetail()
            )

            favoritesStopsViewModel.getBusStopDetail(stopNumber = 79)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            favoritesStopsViewModel.getBusStopDetail(stopNumber = 79)

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

        favoritesStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.isLoading).isFalse()
            assertThat(itemProduced.busStops).isEqualTo(
                emissionExpected.toUiStopDetail()
            )

            favoritesStopsViewModel.getBusStopDetail(stopNumber = 79)

            val itemProducedAfterExpansion = awaitItem()

            assertThat(itemProducedAfterExpansion.busStops).isEqualTo(
                expectedList
            )
            assertThat(itemProducedAfterExpansion.currentExpandedBusStop).isEqualTo(
                expectedList.find { it.stopNumber == 79 }
            )

            favoritesStopsViewModel.getBusStopDetail(stopNumber = 1)

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
    fun `When user calls delete bus stop it should not be available in the busStops list`() = runTest {
        val deletedStop = MutableStateFlow<BusStop?>(null)

        val expected = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isSavedInDb = true
            ),
            BusStop(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isSavedInDb = true
            )
        )
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

        favoritesStopsViewModel.uiState.test {
            val itemProduced = awaitItem()
            assertThat(itemProduced.busStops).isEqualTo(
                fakeListBusStopDetailOffline().toUiStopDetail()
            )

            deletedStop.value = fakeListBusStopDetailOffline()[1]
            favoritesStopsViewModel.deleteBusStop(
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
                    isSavedInDb = true
                )
            )
        }
    }

    @Test
    fun `When a card is expanded and getAllBusStops emits again it should keep the current set as expanded`() = runTest {
        val (_, expectedList) = firstGetDetailSetup()
        val emitAgain = MutableStateFlow(false)

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }
        coEvery {
            getFavoriteBusStopsUseCase()
        } returns flow {
            emit(
                fakeListBusStopDetailOffline()
            )
            favoritesStopsViewModel.getBusStopDetail(stopNumber = 79)
            emitAgain.collect {
                if (it) {
                    emit(
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
                }
            }
        }

        favoritesStopsViewModel.uiState.test {
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
