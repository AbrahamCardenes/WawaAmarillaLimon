package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.lpa_domain.models.core.GpsCoordinates
import com.abrahamcardenes.lpa_domain.models.core.RGBAColor
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusSchedule
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import com.abrahamcardenes.wawaamarillalimon.ServerMocks
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
import com.abrahamcardenes.wawaamarillalimon.jsons.shortStaticAppLinesJson
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
    fun `Given a call to concessions it should return all bus lines`() = runTest {
        val expected = Result.Success(
            Concessions(
                concessions = listOf(
                    ConcessionDetails(
                        name = "Puerto - Hoya de La Plata",
                        commercial = "12",
                        color = RGBAColor(
                            red = 226,
                            green = 0,
                            blue = 26,
                            alpha = 1
                        )
                    ),
                    ConcessionDetails(
                        name = "Mercado de Vegueta - Tres Palmas",
                        commercial = "13",
                        color = RGBAColor(
                            red = 185,
                            green = 102,
                            blue = 161,
                            alpha = 1
                        )
                    ),
                    ConcessionDetails(
                        name = "Teatro - Tamaraceite",
                        commercial = "L3",
                        color = RGBAColor(
                            red = 188,
                            green = 228,
                            blue = 246,
                            alpha = 1
                        )
                    )

                )
            )
        )
        ServerMocks.enqueue(
            code = 200,
            body = shortStaticAppLinesJson,
            mockWebServer = mockWebServer
        )
        val result = repository.getLines()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Given a call to some route line it should return that BusRouteLine`() = runTest {
        val expected = Result.Success(
            BusRoute(
                line = "13",
                name = "Mercado de Vegueta - Tres Palmas",
                color = RGBAColor(
                    red = 185,
                    green = 102,
                    blue = 161,
                    alpha = 1
                ),
                nodes = listOf("Mercado de Vegueta", "Tres Palmas"),
                variantsGo = listOf(
                    Variants(
                        type = "A",
                        name = "Mercado de Vegueta - Tres Palmas",
                        color = RGBAColor(
                            red = 185,
                            green = 102,
                            blue = 161,
                            alpha = 1
                        )
                    )
                ),
                variantsBack = listOf(
                    Variants(
                        type = "B",
                        name = "Tres Palmas - Mercado de Vegueta",
                        color = RGBAColor(
                            red = 185,
                            green = 102,
                            blue = 161,
                            alpha = 1
                        )
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
                ),
                schedules = listOf(
                    BusSchedule(
                        node = "Mercado de Vegueta",
                        typology = "De lunes a viernes",
                        time = "06:55",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        )
                    ),
                    BusSchedule(
                        node = "Mercado de Vegueta",
                        typology = "Sábado",
                        time = "08:05",
                        color = RGBAColor(
                            red = 0,
                            green = 0,
                            blue = 0,
                            alpha = 0
                        )
                    ),
                    BusSchedule(
                        node = "Mercado de Vegueta",
                        typology = "Domingo y festivo",
                        time = "07:50",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        )
                    ),

                    BusSchedule(
                        node = "Tres Palmas",
                        typology = "De lunes a viernes",
                        time = "06:10",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        )
                    ),
                    BusSchedule(
                        node = "Tres Palmas",
                        typology = "Sábado",
                        time = "07:10",
                        color = RGBAColor(
                            red = 245,
                            green = 245,
                            blue = 245,
                            alpha = 1
                        ),
                        variantLetter = "F"
                    ),
                    BusSchedule(
                        node = "Tres Palmas",
                        typology = "Domingo y festivo",
                        time = "08:35",
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
                color = RGBAColor(
                    red = 185,
                    green = 102,
                    blue = 161,
                    alpha = 1
                ),
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
                ),
                schedules = emptyList()
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
