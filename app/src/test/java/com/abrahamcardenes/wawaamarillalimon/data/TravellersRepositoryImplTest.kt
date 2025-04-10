package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.wawaamarillalimon.ServerMocks
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.BusTimetables
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.Concession
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionSchedule
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.ConcessionStop
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.RoutePaths
import com.abrahamcardenes.wawaamarillalimon.domain.models.travellers.TimetableInfo
import com.abrahamcardenes.wawaamarillalimon.fakes.mockedConcessions
import com.abrahamcardenes.wawaamarillalimon.fakes.mockedWawaCardBalance
import com.abrahamcardenes.wawaamarillalimon.jsons.concessionsResponse
import com.abrahamcardenes.wawaamarillalimon.jsons.ogs.ogWawaCardBalanceJson
import com.abrahamcardenes.wawaamarillalimon.jsons.shortLine10Timetable
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TravellersRepositoryImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiTravellers: ApiTravellers
    private lateinit var repository: TravellersRepositoryImpl

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiTravellers = ServerMocks.buildApiTravellersService(mockWebServer = mockWebServer)
        repository = TravellersRepositoryImpl(
            api = apiTravellers
        )
    }

    @After
    fun tearDown() {
        clearAllMocks()
        mockWebServer.shutdown()
    }

    @Test
    fun `Given a 200 OK status it should return a list of concessions`() = runTest {
        val expected = Result.Success(
            mockedConcessions() + listOf(
                Concession(
                    busNumber = 63,
                    name = "TEATRO - TAMARACEITE",
                    commercialName = "L3",
                    color = "#BCE4F6"
                )
            )
        )

        ServerMocks.enqueue(
            code = 200,
            body = concessionsResponse,
            mockWebServer = mockWebServer
        )

        val result = repository.getConcessions()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `When calling a timetable Given a 200 OK status and line 10 it should return a BusTimetables object`() = runTest {
        val expected = Result.Success(
            BusTimetables(
                timetables = listOf(
                    TimetableInfo(
                        lineId = "Teatro - Hosp. Dr. Negrín (Exprés)",
                        node = "Teatro",
                        notes = "Sábado, domingo y festivo no circula",
                        warning = "GC-1 Collapse",
                        routes = listOf(
                            RoutePaths(
                                type = "A",
                                hexColor = "#009036",
                                notes = "Avoid Julio Luengo"
                            )
                        ),
                        concessionStops = listOf(
                            ConcessionStop(
                                name = "Teatro",
                                type = listOf("A")
                            ),
                            ConcessionStop(
                                name = "Hospital Dr. Negrín (Consultas Externas)",
                                type = listOf("A")
                            )
                        ),
                        schedules = listOf(
                            ConcessionSchedule(
                                availableDays = "De lunes a viernes",
                                times = listOf(
                                    "06:15",
                                    "06:40",
                                    "22:35"
                                )
                            )
                        )
                    ),
                    TimetableInfo(
                        lineId = "Hosp. Dr. Negrín - Teatro (Exprés)",
                        node = "Hosp. Dr. Negrín",
                        notes = "Sábado, domingo y festivo no circula",
                        warning = "",
                        routes = listOf(
                            RoutePaths(
                                type = "B",
                                hexColor = "#009036",
                                notes = ""
                            )
                        ),
                        concessionStops = listOf(
                            ConcessionStop(
                                name = "Hospital Dr. Negrín (Consultas Externas)",
                                type = listOf("B")
                            ),
                            ConcessionStop(
                                name = "Av. de Canarias (San Telmo)",
                                type = listOf("B")
                            ),
                            ConcessionStop(
                                name = "Teatro",
                                type = listOf("B")
                            )
                        ),
                        schedules = listOf(
                            ConcessionSchedule(
                                availableDays = "De lunes a viernes",
                                times = listOf(
                                    "06:40",
                                    "07:10",
                                    "22:05"
                                )
                            )
                        )
                    )
                )
            )
        )

        ServerMocks.enqueue(
            code = 200,
            body = shortLine10Timetable,
            mockWebServer = mockWebServer
        )

        val result = repository.getTimetables(busNumber = 10)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Given a wawa card number it should return the balance`() = runTest {
        val expected = Result.Success(
            mockedWawaCardBalance()
        )

        ServerMocks.enqueue(
            code = 200,
            body = ogWawaCardBalanceJson,
            mockWebServer = mockWebServer
        )

        val result = repository.getBalance("529491")

        assertThat(result).isEqualTo(expected)
    }
}
