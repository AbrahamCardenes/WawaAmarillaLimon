package com.abrahamcardenes.lpa_data

import app.cash.turbine.test
import com.abrahamcardenes.core.network.DataError
import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.core_db.BusStopEntity
import com.abrahamcardenes.lpa_data.data.BusStopsRepositoryImpl
import com.abrahamcardenes.lpa_data.data.mappers.toEntity
import com.abrahamcardenes.lpa_data.fakes.fakeBusStopDetail
import com.abrahamcardenes.lpa_data.jsons.mockedBusStopDetail
import com.abrahamcardenes.lpa_data.jsons.mockedBusStopDetailWithLessTime
import com.abrahamcardenes.lpa_data.jsons.ogs.shortOriginalReplication
import com.abrahamcardenes.lpa_data.remote.apis.ApiParadas
import com.abrahamcardenes.lpa_data.utils.ServerMocks
import com.abrahamcardenes.lpa_domain.models.busStops.BusLine
import com.abrahamcardenes.lpa_domain.models.busStops.BusStop
import com.google.common.truth.Truth.assertThat
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class BusStopsRepositoryImplTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiParadas: ApiParadas
    private lateinit var repository: BusStopsRepositoryImpl
    private lateinit var busStopDao: BusStopDao
    private lateinit var crashlyticsService: CrashlyticsService

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiParadas = ServerMocks.buildApiParadasService(mockWebServer = mockWebServer)
        busStopDao = mockk(relaxed = true)
        crashlyticsService = mockk(relaxed = true)
        repository = BusStopsRepositoryImpl(
            api = apiParadas,
            busStopDao = busStopDao,
            dispatchersProvider = TestsDispatchers,
            coroutineScope = CoroutineScope(UnconfinedTestDispatcher()),
            crashlyticsService = crashlyticsService
        )
    }

    @After
    fun clean() {
        clearAllMocks()
        mockWebServer.shutdown()
    }

    @Test
    fun `Given the mocked response it should be mapped correctly to a list of BusStops, avoiding the PAR, NAME bus stop and repetition`() = runTest {
        ServerMocks.enqueue(
            code = 200,
            body = shortOriginalReplication,
            mockWebServer = mockWebServer
        )
        val expected = listOf(
            BusStopEntity(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = false
            ),
            BusStopEntity(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = false
            )
        )

        coEvery {
            busStopDao.upsertAll(expected)
        } just Runs

        coVerify {
            busStopDao.upsertAll(expected)
        }
    }

    @Test
    fun `Given a 404 from API the it should log the error and not call db upsert`() = runTest {
        ServerMocks.enqueue(
            code = 404,
            body = "",
            mockWebServer = mockWebServer
        )

        coVerify {
            crashlyticsService.logException(any())
        }

        coVerify(exactly = 0) {
            busStopDao.upsertAll(any())
        }
    }

    @Test
    fun `Given a BusStop model it should call the update favorite function from db`() = runTest {
        val busStop = BusStop(
            addressName = "TEATRO",
            stopNumber = 1,
            isFavorite = false
        )

        repository.updateBusStopInDb(busStop)

        coVerifySequence {
            busStop.toEntity()
            busStopDao.updateFavorite(
                stopNumber = 1,
                isFavorite = false
            )
        }
    }

    @Test
    fun `When calling offline bustops it should get all the bus stops from the database`() = runTest {
        val listOfOneItem = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = true
            )
        )

        val listOfThreeItems = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isFavorite = true
            ),
            BusStop(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isFavorite = true
            ),
            BusStop(
                addressName = "TEATRO, 99",
                stopNumber = 99,
                isFavorite = true
            )
        )

        coEvery {
            busStopDao.getBusStopsFlow()
        } returns flow {
            emit(listOfOneItem.map { it.toEntity() })
            emit(listOfThreeItems.map { it.toEntity() })
        }

        repository.getAllLocalBusStops().test {
            assertThat(listOfOneItem).isEqualTo(awaitItem())
            assertThat(listOfThreeItems).isEqualTo(awaitItem())
            awaitComplete()
        }
        coVerify(exactly = 1) {
            busStopDao.getBusStopsFlow()
        }
    }

    @Test
    fun `Given a busStop number it should return the detail of that stop`() = runTest {
        firstApiCall()
        val firstExpectedEmission = Result.Success(fakeBusStopDetail())
        val secondExpectedEmission = Result.Success(
            fakeBusStopDetail().copy(
                availableBusLines = listOf(
                    BusLine(
                        number = "13",
                        destination = "TRESPALMAS",
                        arrivalTimeIn = "2min"
                    ),
                    BusLine(
                        number = "X47",
                        destination = "Tamaraceite",
                        arrivalTimeIn = "1min"
                    )
                )
            )
        )

        ServerMocks.enqueue(
            code = 200,
            body = mockedBusStopDetail,
            mockWebServer = mockWebServer
        )
        ServerMocks.enqueue(
            code = 200,
            body = mockedBusStopDetailWithLessTime,
            mockWebServer = mockWebServer
        )

        repository.getBusDetailStop(stopNumber = 79).test {
            assertThat(awaitItem()).isEqualTo(firstExpectedEmission)
            assertThat(awaitItem()).isEqualTo(secondExpectedEmission)
        }
    }

    @Test
    fun `Given a 500 error it should return DataError Remote SERVER`() = runTest {
        firstApiCall()
        ServerMocks.enqueue(
            code = 500,
            body = "",
            mockWebServer = mockWebServer
        )

        repository.getBusDetailStop(stopNumber = 79).test {
            val emission = awaitItem()
            assertThat(emission).isEqualTo(Result.Error(DataError.Remote.ServerFailure))
            cancel()
        }
    }

    @Test
    fun `Given a 400 error it should return null`() = runTest {
        firstApiCall()
        ServerMocks.enqueue(
            code = 400,
            body = "",
            mockWebServer = mockWebServer
        )

        repository.getBusDetailStop(stopNumber = 79).test {
            val emission = awaitItem()
            assertThat(emission).isEqualTo(Result.Error(DataError.Remote.BadRequest))
            cancel()
        }
    }

    private fun firstApiCall() {
        ServerMocks.enqueue(
            code = 200,
            body = shortOriginalReplication,
            mockWebServer = mockWebServer
        )
    }
}
