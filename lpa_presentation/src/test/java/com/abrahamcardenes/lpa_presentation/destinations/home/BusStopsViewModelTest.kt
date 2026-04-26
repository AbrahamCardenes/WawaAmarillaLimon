package com.abrahamcardenes.lpa_presentation.destinations.home

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.abrahamcardenes.lpa_domain.models.busStops.BusStopDetail
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetBusDetailUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.GetBusStopsUseCase
import com.abrahamcardenes.lpa_domain.useCases.busStops.UpdateLocalBusStopUseCase
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
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BusStopsViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val getBusDetailUseCase = mockk<GetBusDetailUseCase>()
    private val updateLocalBusStopUseCase = mockk<UpdateLocalBusStopUseCase>()
    private val getBusStopsUseCase = mockk<GetBusStopsUseCase>()

    private val crashlyticsService = mockk<CrashlyticsService>(relaxed = true)
    private lateinit var busStopsViewModel: BusStopsViewModel
    private val dispatchers = TestsDispatchers

    @Before
    fun setup() {
        busStopsViewModel = BusStopsViewModel(
            getBusStopsUseCase = getBusStopsUseCase,
            getBusDetailUseCase = getBusDetailUseCase,
            updateLocalBusStopUseCase = updateLocalBusStopUseCase,
            crashlyticsService = crashlyticsService,
            dispatchers = dispatchers
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
    }

    private fun firstGetDetailSetup(isSecondFavorite: Boolean = false): Pair<Result<List<BusStop>, DataError>, List<UiBusStopDetail>> {
        val emissionExpected = Result.Success(fakeListBusStopDetail(setSecondToFavorite = isSecondFavorite))
        val expectedList = fakeListUiBusStopDetail(isExpanded = true, lines = fakeBusStopDetail().availableBusLines, isSecondFavorite = isSecondFavorite)
        return Pair(emissionExpected, expectedList)
    }

    @Test
    fun `When starting viewModel it should be loading and no busStops`() = runTest {
        busStopsViewModel.busStopsState.value.selectedTab shouldBe BusStopTabs.All
        busStopsViewModel.busStopsState.value.state shouldBe BusStopState.Loading
        busStopsViewModel.busStopsState.value.busStops shouldBe emptyList<BusStop>()
        busStopsViewModel.busStopsState.value.favoriteBusStops shouldBe emptyList<BusStop>()
    }

    @Test
    fun `Given getAllBusStops emits data and Then it should update both lists`() = runTest {
        val listToEmit = fakeListBusStopDetail(setSecondToFavorite = true)
        val expected = listToEmit.toUiStopDetail()

        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(listToEmit)
        }

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            itemProduced.busStops shouldBe expected
            itemProduced.favoriteBusStops shouldBe fakeListBusStopDetailOffline().toUiStopDetail()
        }
    }

    @Test
    fun `When getAllBusStops emits empty list Then it should be success without data`() = runTest {
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(
                emptyList()
            )
        }

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            itemProduced.busStops shouldBe emptyList()
            itemProduced.favoriteBusStops shouldBe emptyList()
        }
    }

    @Test
    fun `Given a list without favorites When user inputs some text it should return the one with that in online list`() = runTest {
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail())
        }

        val expected = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            )
        )

        busStopsViewModel.updateUserInput("PASEO DE SAN")

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            itemProduced.userInput shouldBe "PASEO DE SAN"
            itemProduced.busStops shouldBe expected
            itemProduced.favoriteBusStops shouldBe emptyList()
        }
    }

    @Test
    fun `Given a list with favorites When user inputs stopNumber it should return the one with that in both lists`() = runTest {
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail(setSecondToFavorite = true))
        }

        val expected = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = null
            )
        )

        busStopsViewModel.updateUserInput("79")

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            itemProduced.userInput shouldBe "79"
            itemProduced.busStops shouldBe expected
            itemProduced.favoriteBusStops shouldBe expected
        }
    }

    @Test
    fun `When user inputs some text and there is not matches it should return empty`() = runTest {
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail(setSecondToFavorite = true))
        }

        busStopsViewModel.updateUserInput("Some random text")
        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            itemProduced.userInput shouldBe "Some random text"
            itemProduced.busStops shouldBe emptyList()
            itemProduced.favoriteBusStops shouldBe emptyList()
        }
    }

    @Test
    fun `When the user clicks favorite icon Then it should call update use case`() = runTest {
        val fakeFlow = MutableSharedFlow<List<BusStop>>()
        coEvery { getBusStopsUseCase() } returns fakeFlow
        val firstBusStopsToEmit = fakeListBusStopDetail(setSecondToFavorite = true)

        val expectedLastEmission = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = true
            ),
            BusStop(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true
            ),
            BusStop(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = false
            )
        )

        coEvery {
            updateLocalBusStopUseCase(
                BusStop(
                    addressName = "TEATRO",
                    stopNumber = 1,
                    isFavorite = false
                )
            )
        } returns Unit

        val busStopToSetFavorite = UiBusStopDetail(
            addressName = "TEATRO",
            stopNumber = 1,
            availableBusLines = null,
            isExpanded = false,
            isFavorite = false
        )

        busStopsViewModel.busStopsState.test {
            val loadingEmission = awaitItem()
            loadingEmission.state shouldBe BusStopState.Loading

            fakeFlow.emit(firstBusStopsToEmit)
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            itemProduced.busStops shouldBe firstBusStopsToEmit.toUiStopDetail()

            busStopsViewModel.updateLocalBusStopFavoriteStatus(busStopToSetFavorite)
            fakeFlow.emit(expectedLastEmission)

            val secondEmission = awaitItem()
            secondEmission.busStops shouldBe expectedLastEmission.toUiStopDetail()
        }

        coVerify(exactly = 1) {
            updateLocalBusStopUseCase(fakeListBusStopDetail().toUiStopDetail().first().toBusStop())
        }
    }

    @Test
    fun `When user expands an Online bus stop Then it should be set as expanded`() = runTest {
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail())
        }

        val (emissionExpected, expectedList) = firstGetDetailSetup()

        useCasesMocksToTestDetails()

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            emissionExpected.onSuccess {
                itemProduced.busStops shouldBe it.toUiStopDetail()
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()
            itemProducedAfterExpansion.busStops shouldBe expectedList
            itemProducedAfterExpansion.currentExpandedBusStop shouldBe expectedList.find { it.stopNumber == 79 }
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user expands a Favorite card bus stop it should be set as expanded`() = runTest {
        val expectedFavorite = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = true,
                availableBusLines = fakeBusStopDetail().availableBusLines
            )
        )

        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail(setSecondToFavorite = true))
        }

        val emissionExpected = Result.Success(fakeListBusStopDetail(setSecondToFavorite = true))

        useCasesMocksToTestDetails()

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            emissionExpected.onSuccess {
                itemProduced.busStops shouldBe it.toUiStopDetail()
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterExpansion = awaitItem()
            itemProducedAfterExpansion.busStops shouldBe fakeListBusStopDetail(setSecondToFavorite = true).toUiStopDetail()
            itemProducedAfterExpansion.favoriteBusStops shouldBe expectedFavorite
            itemProducedAfterExpansion.currentExpandedBusStop shouldBe expectedFavorite.first()
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user collapse a Favorite card bus stop it should be set as not expanded`() = runTest {
        val expectedFavorite = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = true,
                availableBusLines = fakeBusStopDetail().availableBusLines
            )
        )

        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail(setSecondToFavorite = true))
        }

        useCasesMocksToTestDetails()

        val emissionExpected = Result.Success(fakeListBusStopDetail(setSecondToFavorite = true))

        val expectedCollapsedList = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = fakeBusStopDetail().availableBusLines
            )
        )

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            emissionExpected.onSuccess {
                itemProduced.busStops shouldBe it.toUiStopDetail()
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterExpansion = awaitItem()
            itemProducedAfterExpansion.busStops shouldBe fakeListBusStopDetail(setSecondToFavorite = true).toUiStopDetail()
            itemProducedAfterExpansion.favoriteBusStops shouldBe expectedFavorite
            itemProducedAfterExpansion.currentExpandedBusStop shouldBe expectedFavorite.first()

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterCollapsing = awaitItem()
            itemProducedAfterCollapsing.favoriteBusStops shouldBe expectedCollapsedList

            itemProducedAfterCollapsing.currentExpandedBusStop shouldBe null
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user selects a different Online card it should collapse the old one and expand the new`() = runTest {
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail())
        }

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

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            emissionExpected.onSuccess {
                itemProduced.busStops shouldBe it.toUiStopDetail()
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()

            itemProducedAfterExpansion.busStops shouldBe expectedList

            itemProducedAfterExpansion.currentExpandedBusStop shouldBe expectedList.find { it.stopNumber == 79 }

            busStopsViewModel.getBusStopDetail(stopNumber = 1, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterCollapsing = awaitItem()
            itemProducedAfterCollapsing.busStops shouldBe expectedUpdatedList

            itemProducedAfterCollapsing.currentExpandedBusStop shouldBe expectedUpdatedList.find { it.stopNumber == 1 }
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
            getBusDetailUseCase(stopNumber = 1)
        }
    }

    @Test
    fun `When user selects a different Favorite card it should collapse the old one and expand the new`() = runTest {
        val expectedFirstExpandedBusStop = UiBusStopDetail(
            addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
            stopNumber = 79,
            isFavorite = true,
            isExpanded = true,
            availableBusLines = listOf(
                BusLine(
                    number = "13",
                    destination = "TRESPALMAS",
                    arrivalTimeIn = "15min"
                )
            )
        )

        val emissionExpected = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = true
            ),
            BusStop(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true
            )
        )

        val expectedFirstExpansion = listOf(
            UiBusStopDetail(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = null
            ),
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = true,
                availableBusLines = listOf(
                    BusLine(
                        number = "13",
                        destination = "TRESPALMAS",
                        arrivalTimeIn = "15min"
                    )
                )
            )
        )

        val expectedSecondEmission = listOf(
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
            )
        )

        val expectedSecondExpandedCard = UiBusStopDetail(
            addressName = "TEATRO",
            stopNumber = 1,
            isFavorite = true,
            isExpanded = true,
            availableBusLines = emptyList()
        )

        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(
                listOf(
                    BusStop(
                        addressName = "TEATRO",
                        stopNumber = 1,
                        isFavorite = true
                    ),
                    BusStop(
                        addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                        stopNumber = 79,
                        isFavorite = true
                    ),
                    BusStop(
                        addressName = "C / FRANCISCO GOURIÉ, 103",
                        stopNumber = 2,
                        isFavorite = false
                    )
                )
            )
        }

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

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()

            itemProduced.favoriteBusStops shouldBe emissionExpected.toUiStopDetail()

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)
            val itemProducedAfterExpansion = awaitItem()

            itemProducedAfterExpansion.favoriteBusStops shouldBe expectedFirstExpansion
            itemProducedAfterExpansion.currentExpandedBusStop shouldBe expectedFirstExpandedBusStop

            busStopsViewModel.getBusStopDetail(stopNumber = 1, origin = BusStopOrigin.FAVORITES)

            val itemProducedAfterCollapsing = awaitItem()
            itemProducedAfterCollapsing.favoriteBusStops shouldBe expectedSecondEmission
            itemProducedAfterCollapsing.currentExpandedBusStop shouldBe expectedSecondExpandedCard
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
            getBusDetailUseCase(stopNumber = 1)
        }
    }

    @Test
    fun `When fetching details for a bus stop fails it should show the empty list with the bus stop expanded`() = runTest {
        val expectedExpanded = UiBusStopDetail(
            addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
            stopNumber = 79,
            isFavorite = true,
            isExpanded = true,
            availableBusLines = emptyList()
        )

        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail(setSecondToFavorite = true))
        }

        useCasesMocksToTestDetails()

        val emissionExpected = Result.Success(fakeListBusStopDetail(setSecondToFavorite = true))

        val expected = fakeListUiBusStopDetailOffline(
            isExpanded = true,
            lines = emptyList(),
            setFavorite = true
        )

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Error(DataError.Remote.ServerFailure)
            )
        }

        busStopsViewModel.busStopsState.test {
            val itemProduced = awaitItem()
            itemProduced.state shouldBe BusStopState.Success
            emissionExpected.onSuccess {
                itemProduced.busStops shouldBe it.toUiStopDetail()
            }

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()
            itemProducedAfterExpansion.busStops shouldBe expected
            itemProducedAfterExpansion.currentExpandedBusStop shouldBe expectedExpanded
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When user collapse a card bus stop it should be set as not expanded`() = runTest {
        val expectedList = listOf(
            UiBusStopDetail(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            ),
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = fakeBusStopDetail().availableBusLines
            ),
            UiBusStopDetail(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            )
        )
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail())
        }

        useCasesMocksToTestDetails()

        busStopsViewModel.busStopsState.test {
            skipItems(1)
            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)
            skipItems(1)
            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val itemProducedAfterExpansion = awaitItem()
            itemProducedAfterExpansion.busStops shouldBe expectedList
            itemProducedAfterExpansion.currentExpandedBusStop shouldBe null
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `Given an open card online When user switches to Favorite tab it should collapse the card`() = runTest {
        val expectedList = listOf(
            UiBusStopDetail(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            ),
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = fakeBusStopDetail().availableBusLines
            ),
            UiBusStopDetail(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = false,
                isExpanded = false,
                availableBusLines = null
            )
        )
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail())
        }

        useCasesMocksToTestDetails()

        busStopsViewModel.busStopsState.test {
            skipItems(1)
            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)
            skipItems(1)
            busStopsViewModel.onTabClick(busStopTab = BusStopTabs.Favorites)

            val itemAfterSwitchingTab = awaitItem()
            assertThat(itemAfterSwitchingTab.busStops).isEqualTo(
                expectedList.map { it.copy(isExpanded = false) }
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
        val expectedList = listOf(
            UiBusStopDetail(
                addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
                stopNumber = 79,
                isFavorite = true,
                isExpanded = false,
                availableBusLines = fakeBusStopDetail().availableBusLines
            )
        )
        coEvery {
            getBusStopsUseCase()
        } returns flow {
            emit(fakeListBusStopDetail(setSecondToFavorite = true))
        }

        useCasesMocksToTestDetails()

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }

        busStopsViewModel.busStopsState.test {
            skipItems(1)
            busStopsViewModel.onTabClick(busStopTab = BusStopTabs.Favorites)
            val firstTapSwitch = awaitItem()
            firstTapSwitch.selectedTab shouldBe BusStopTabs.Favorites
            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.FAVORITES)
            skipItems(1)

            busStopsViewModel.onTabClick(busStopTab = BusStopTabs.All)
            val itemAfterSwitchingTab = awaitItem()
            itemAfterSwitchingTab.favoriteBusStops shouldBe expectedList
            itemAfterSwitchingTab.currentExpandedBusStop shouldBe null

            val emissionTabChanged = awaitItem()
            emissionTabChanged.selectedTab shouldBe BusStopTabs.All
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }

    @Test
    fun `When a card is expanded and getAllBusStops emits again it should keep the current set as expanded`() = runTest {
        val expectedResult = fakeListUiBusStopDetail(isExpanded = true, lines = fakeBusStopDetail().availableBusLines).toMutableList().apply {
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

        val expectedExpanded = UiBusStopDetail(
            addressName = "PASEO DE SAN JOSÉ (IGLESIA SAN JOSÉ)",
            stopNumber = 79,
            isFavorite = false,
            isExpanded = true,
            availableBusLines = fakeBusStopDetail().availableBusLines
        )

        val fakeFlow = MutableSharedFlow<List<BusStop>>()
        coEvery { getBusStopsUseCase() } returns fakeFlow

        coEvery {
            getBusDetailUseCase(stopNumber = 79)
        } returns flow {
            emit(
                Result.Success(fakeBusStopDetail())
            )
        }
        coEvery {
            getBusStopsUseCase()
        } returns fakeFlow

        busStopsViewModel.busStopsState.test {
            skipItems(1)
            fakeFlow.emit(
                fakeListBusStopDetail()
            )
            val firstItemProduced = awaitItem()
            firstItemProduced.busStops shouldBe fakeListBusStopDetail().toUiStopDetail()

            busStopsViewModel.getBusStopDetail(stopNumber = 79, origin = BusStopOrigin.ONLINE)

            val secondItemProduced = awaitItem()
            secondItemProduced.currentExpandedBusStop shouldBe expectedExpanded

            fakeFlow.emit(
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
            val itemProducedAfterSecondGetAllEmission = awaitItem()
            itemProducedAfterSecondGetAllEmission.busStops shouldBe expectedResult
            itemProducedAfterSecondGetAllEmission.currentExpandedBusStop shouldBe expectedExpanded
        }

        coVerify(exactly = 1) {
            getBusDetailUseCase(stopNumber = 79)
        }
    }
}
