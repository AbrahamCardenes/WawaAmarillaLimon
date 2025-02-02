package com.abrahamcardenes.wawaamarillalimon.data

import app.cash.turbine.test
import com.abrahamcardenes.wawaamarillalimon.ServerMocks
import com.abrahamcardenes.wawaamarillalimon.data.mappers.toEntity
import com.abrahamcardenes.wawaamarillalimon.datasource.local.BusStopDao
import com.abrahamcardenes.wawaamarillalimon.datasource.local.BusStopEntity
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusLine
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStopDetail
import com.abrahamcardenes.wawaamarillalimon.jsons.mockedBusStopDetail
import com.abrahamcardenes.wawaamarillalimon.jsons.mockedBusStopDetailWithLessTime
import com.abrahamcardenes.wawaamarillalimon.jsons.mockedBusStops
import com.abrahamcardenes.wawaamarillalimon.jsons.originalResponseFromApiParadas
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
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

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiParadas = ServerMocks.buildApiParadasService(mockWebServer = mockWebServer)
        busStopDao = mockk(relaxed = true)
        repository =
            BusStopsRepositoryImpl(
                api = apiParadas,
                busStopDao = busStopDao
            )
    }

    @After
    fun clean() {
        clearAllMocks()
        mockWebServer.shutdown()
    }

    @Test
    fun `Given the original response it should remove the incorrect Bus Stop with addressName NOMBRE and number PAR`() = runTest {
        ServerMocks.enqueue(
            code = 200,
            body = originalResponseFromApiParadas,
            mockWebServer = mockWebServer
        )
        val response = repository.getBusStops()
        assertThat(response.size).isEqualTo(3422)
        assertThat(response.find { it.addressName == "NOMBRE" }).isNull()
    }

    @Test
    fun `Given the mocked response it should be mapped correctly to a list of BusStops`() = runTest {
        val expected =
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
                    addressName = "TEATRO",
                    stopNumber = 1,
                    isSavedInDb = false
                )
            )
        ServerMocks.enqueue(
            code = 200,
            body = mockedBusStops,
            mockWebServer = mockWebServer
        )
        val response = repository.getBusStops()
        assertThat(response.size).isEqualTo(3)
        assertThat(response.find { it.addressName == "NOMBRE" }).isNull()
        assertThat(response).isEqualTo(expected)
    }


    @Test
    fun `Given a BusStop model it should be saved in the database`() = runTest {
        val busStop =
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isSavedInDb = false
            )

        repository.saveStops(busStop)

        coVerifySequence {
            busStop.toEntity()
            busStopDao.insertBusStop(
                BusStopEntity(
                    addressName = "TEATRO",
                    stopNumber = 1
                )
            )
        }
    }

    @Test
    fun `Given a BusStop model it should be deleted in the database`() = runTest {
        val busStop =
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isSavedInDb = false
            )

        repository.deleteBusStop(busStop)

        coVerifySequence {
            busStop.toEntity()
            busStopDao.deleteBusStop(
                BusStopEntity(
                    addressName = "TEATRO",
                    stopNumber = 1
                )
            )
        }
    }


    @Test
    fun `When calling offline bustops it should get all the bus stops from the database`() = runTest {
        val listOfOneItem = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isSavedInDb = true
            )
        )

        val listOfThreeItems = listOf(
            BusStop(
                addressName = "TEATRO",
                stopNumber = 1,
                isSavedInDb = true
            ),
            BusStop(
                addressName = "C / FRANCISCO GOURIÉ, 103",
                stopNumber = 2,
                isSavedInDb = true
            ),
            BusStop(
                addressName = "TEATRO, 99",
                stopNumber = 99,
                isSavedInDb = true
            )
        )

        coEvery {
            busStopDao.getBusStops()
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
            busStopDao.getBusStops()
        }
    }


    @Test
    fun `Given a busStop number it should return the detail of that stop`() = runTest {
        val firstExpectedEmission = BusStopDetail(
            addressName = "Pº SAN JOSÉ (IGLESIA SAN JOSÉ)",
            availableBusLines = listOf(
                BusLine(
                    number = 13,
                    destination = "TRESPALMAS",
                    arrivalTimeIn = "15min"
                )
            )
        )

        val secondExpedtedEmission = BusStopDetail(
            addressName = "Pº SAN JOSÉ (IGLESIA SAN JOSÉ)",
            availableBusLines = listOf(
                BusLine(
                    number = 13,
                    destination = "TRESPALMAS",
                    arrivalTimeIn = "2min"
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
            assertThat(awaitItem()).isEqualTo(secondExpedtedEmission)
        }
    }


    @Test
    fun `Given a 500 error it should return null`() = runTest {
        ServerMocks.enqueue(
            code = 500,
            body = "",
            mockWebServer = mockWebServer
        )

        val busStopDetailResponse = repository.getBusDetailStop(stopNumber = 79).single()

        assertThat(busStopDetailResponse).isNull()
    }
}
