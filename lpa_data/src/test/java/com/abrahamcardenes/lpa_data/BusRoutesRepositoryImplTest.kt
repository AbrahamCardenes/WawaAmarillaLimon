package com.abrahamcardenes.lpa_data

import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core.network.onSuccess
import com.abrahamcardenes.lpa_data.data.BusRoutesRepositoryImpl
import com.abrahamcardenes.lpa_data.jsons.shortStaticAppLinesJson
import com.abrahamcardenes.lpa_data.remote.apis.ApiStaticApp
import com.abrahamcardenes.lpa_data.utils.ServerMocks
import com.abrahamcardenes.lpa_domain.models.common.GpsCoordinates
import com.abrahamcardenes.lpa_domain.models.common.WawaColor
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusRoute
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.BusSchedule
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.RouteStop
import com.abrahamcardenes.lpa_domain.models.staticApp.busRoutes.Variants
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.ConcessionDetails
import com.abrahamcardenes.lpa_domain.models.staticApp.concessions.Concessions
import emptyLatitudeAndLongitude
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.runner.junit4.FunSpec
import io.mockk.clearAllMocks
import okhttp3.mockwebserver.MockWebServer
import shortStaticAppBusLine13

class BusRoutesRepositoryImplTest : FunSpec(
    {
        lateinit var mockWebServer: MockWebServer
        lateinit var apiStaticApp: ApiStaticApp
        lateinit var repository: BusRoutesRepositoryImpl

        beforeTest {
            mockWebServer = MockWebServer()
            apiStaticApp = ServerMocks.buildApiStaticAppService(mockWebServer = mockWebServer)
            repository = BusRoutesRepositoryImpl(
                apiService = apiStaticApp
            )
        }

        afterTest {
            clearAllMocks()
            mockWebServer.shutdown()
        }

        test("Given a call to concessions it should return all bus lines") {
            val expected = Result.Success(
                Concessions(
                    concessions = listOf(
                        ConcessionDetails(
                            name = "Puerto - Hoya de La Plata",
                            commercial = "12",
                            color = WawaColor(
                                red = 226,
                                green = 0,
                                blue = 26,
                                alpha = 1f
                            )
                        ),
                        ConcessionDetails(
                            name = "Mercado de Vegueta - Tres Palmas",
                            commercial = "13",
                            color = WawaColor(
                                red = 185,
                                green = 102,
                                blue = 161,
                                alpha = 1f
                            )
                        ),
                        ConcessionDetails(
                            name = "Teatro - Tamaraceite",
                            commercial = "L3",
                            color = WawaColor(
                                red = 188,
                                green = 228,
                                blue = 246,
                                alpha = 1f
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
            result.onSuccess {
                val concessions = (result as Result.Success).data.concessions
                concessions shouldHaveSize 3
                concessions.map { it.commercial } shouldContain "13"
            }

            result shouldBe expected
        }

        test("Given a call to some route line it should return that BusRouteLine") {
            val expected = Result.Success(
                BusRoute(
                    line = "13",
                    name = "Mercado de Vegueta - Tres Palmas",
                    color = WawaColor(
                        red = 185,
                        green = 102,
                        blue = 161,
                        alpha = 1f
                    ),
                    nodes = listOf("Mercado de Vegueta", "Tres Palmas"),
                    variantsGo = listOf(
                        Variants(
                            type = "A",
                            name = "Mercado de Vegueta - Tres Palmas",
                            color = WawaColor(
                                red = 185,
                                green = 102,
                                blue = 161,
                                alpha = 1f
                            )
                        )
                    ),
                    variantsBack = listOf(
                        Variants(
                            type = "B",
                            name = "Tres Palmas - Mercado de Vegueta",
                            color = WawaColor(
                                red = 185,
                                green = 102,
                                blue = 161,
                                alpha = 1f
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
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            )
                        ),
                        BusSchedule(
                            node = "Mercado de Vegueta",
                            typology = "Sábado",
                            time = "08:05",
                            color = WawaColor(
                                red = 0,
                                green = 0,
                                blue = 0,
                                alpha = 0f
                            )
                        ),
                        BusSchedule(
                            node = "Mercado de Vegueta",
                            typology = "Domingo y festivo",
                            time = "07:50",
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            )
                        ),

                        BusSchedule(
                            node = "Tres Palmas",
                            typology = "De lunes a viernes",
                            time = "06:10",
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            )
                        ),
                        BusSchedule(
                            node = "Tres Palmas",
                            typology = "Sábado",
                            time = "07:10",
                            color = WawaColor(
                                red = 245,
                                green = 245,
                                blue = 245,
                                alpha = 1f
                            ),
                            variantLetter = "F"
                        ),
                        BusSchedule(
                            node = "Tres Palmas",
                            typology = "Domingo y festivo",
                            time = "08:35",
                            color = WawaColor(
                                red = 0,
                                green = 0,
                                blue = 0,
                                alpha = 0f
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

            repository.getBusRoutes(busNumber = "13") shouldBe expected
        }

        test("Given given a null latitude or longitude it should return BusRouteLine with gps coordinates null") {
            val expected = Result.Success(
                BusRoute(
                    line = "13",
                    name = "Mercado de Vegueta - Tres Palmas",
                    color = WawaColor(
                        red = 185,
                        green = 102,
                        blue = 161,
                        alpha = 1f
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
            repository.getBusRoutes(busNumber = "13") shouldBe expected
        }
    }
)
