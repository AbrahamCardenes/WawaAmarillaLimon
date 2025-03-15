package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.ServerMocks
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.BusRoute
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.RouteStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.busRoutes.Variants
import com.abrahamcardenes.wawaamarillalimon.domain.models.core.GpsCoordinates
import com.google.common.truth.Truth.assertThat
import emptyLatitudeAndLongitude
import io.mockk.clearAllMocks
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import shortStaticAppBusLine13

class BusRoutesRepositoryImplTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiStaticApp: ApiStaticApp
    private lateinit var repository: BusRoutesRepositoryImpl

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiStaticApp = ServerMocks.buildApiStaticAppService(mockWebServer = mockWebServer)
        repository = BusRoutesRepositoryImpl(
            apiService = apiStaticApp
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
        mockWebServer.shutdown()
    }

    @Test
    fun `Given a call to some route line it should return that BusRouteLine`() = runTest {
        val expected = Result.Success(
            BusRoute(
                line = "13",
                name = "Mercado de Vegueta - Tres Palmas",
                color = "rgb(185, 102, 161)",
                nodes = listOf("Mercado de Vegueta", "Tres Palmas"),
                variantsGo = listOf(
                    Variants(
                        type = "A",
                        name = "Mercado de Vegueta - Tres Palmas",
                        color = "rgb(185, 102, 161)"
                    )
                ),
                variantsBack = listOf(
                    Variants(
                        type = "B",
                        name = "Tres Palmas - Mercado de Vegueta",
                        color = "rgb(185, 102, 161)"
                    )
                ),
                stops = listOf(
                    RouteStop(
                        number = "993",
                        name = "Mercado de Vegueta",
                        gpsCoordinates = GpsCoordinates(
                            longitude = -15.41300107,
                            latitude = 28.10265634
                        ),
                        node = "Mercado de Vegueta",
                        variants = listOf("A")
                    ),
                    RouteStop(
                        number = "936",
                        name = "Tres Palmas",
                        gpsCoordinates = GpsCoordinates(
                            latitude = 28.06985503,
                            longitude = -15.42283358
                        ),
                        node = "Mercado de Vegueta",
                        variants = listOf("A")
                    ),
                    RouteStop(
                        number = "936",
                        name = "Tres Palmas",
                        gpsCoordinates = GpsCoordinates(
                            latitude = 28.06985503,
                            longitude = -15.42283358
                        ),
                        node = "Tres Palmas",
                        variants = listOf("B")
                    ),
                    RouteStop(
                        number = "993",
                        name = "Mercado de Vegueta",
                        gpsCoordinates = GpsCoordinates(
                            latitude = 28.10265634,
                            longitude = -15.41300107
                        ),
                        node = "Tres Palmas",
                        variants = listOf("B")
                    )
                )
            )
        )
        ServerMocks.enqueue(
            code = 200,
            body = shortStaticAppBusLine13,
            mockWebServer = mockWebServer
        )
        val result = repository.getBusRoutes(busNumber = "13")
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Given given a null latitude or longitude it should return BusRouteLine with gps coordinates null`() = runTest {
        val expected = Result.Success(
            BusRoute(
                line = "13",
                name = "Mercado de Vegueta - Tres Palmas",
                color = "rgb(185, 102, 161)",
                nodes = listOf("Mercado de Vegueta", "Tres Palmas"),
                variantsGo = emptyList(),
                variantsBack = emptyList(),
                stops = listOf(
                    RouteStop(
                        number = "993",
                        name = "Mercado de Vegueta",
                        gpsCoordinates = null,
                        node = "Mercado de Vegueta",
                        variants = listOf("A")
                    ),
                    RouteStop(
                        number = "936",
                        name = "Tres Palmas",
                        gpsCoordinates = null,
                        node = "Tres Palmas",
                        variants = listOf("B")
                    )
                )
            )
        )
        ServerMocks.enqueue(
            code = 200,
            body = emptyLatitudeAndLongitude,
            mockWebServer = mockWebServer
        )
        val result = repository.getBusRoutes(busNumber = "13")
        assertThat(result).isEqualTo(expected)
    }
}
