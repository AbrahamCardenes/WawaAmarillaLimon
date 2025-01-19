package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.ServerMocks
import com.abrahamcardenes.wawaamarillalimon.datasource.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.domain.models.BusStop
import com.abrahamcardenes.wawaamarillalimon.jsons.mockedBusStops
import com.abrahamcardenes.wawaamarillalimon.jsons.originalResponseFromApiParadas
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test


class BusStopsRepositoryImplTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiParadas: ApiParadas
    private lateinit var repository: BusStopsRepositoryImpl

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiParadas = ServerMocks.buildApiParadasService(mockWebServer = mockWebServer)
        repository = BusStopsRepositoryImpl(
            api = apiParadas
        )
    }

    @After
    fun clean() {
        clearAllMocks()
        mockWebServer.shutdown()
    }


    @Test
    fun `Given the original response it should remove the incorrect Bus Stop with addressName NOMBRE and number PAR`() =
        runTest {
            ServerMocks.enqueue(
                code = 200, body = originalResponseFromApiParadas, mockWebServer = mockWebServer
            )
            val response = repository.getBusStops()
            assertThat(response.size).isEqualTo(3422)
            assertThat(response.find { it.addressName == "NOMBRE" }).isNull()
        }


    @Test
    fun `Given the mocked response it should be mapped correctly to a list of BusStops`() =
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
                    addressName = "TEATRO",
                    stopNumber = 1
                )
            )
            ServerMocks.enqueue(
                code = 200, body = mockedBusStops, mockWebServer = mockWebServer
            )
            val response = repository.getBusStops()
            assertThat(response.size).isEqualTo(3)
            assertThat(response.find { it.addressName == "NOMBRE" }).isNull()
            assertThat(response).isEqualTo(expected)
        }

}


