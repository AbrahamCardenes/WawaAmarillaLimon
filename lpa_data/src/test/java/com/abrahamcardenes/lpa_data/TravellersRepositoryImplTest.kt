package com.abrahamcardenes.lpa_data

import com.abrahamcardenes.core.network.Result
import com.abrahamcardenes.core_android.date.DateProvider
import com.abrahamcardenes.core_db.cards.WawaBalanceDao
import com.abrahamcardenes.lpa_data.data.TravellersRepositoryImpl
import com.abrahamcardenes.lpa_data.fakes.mockedConcessions
import com.abrahamcardenes.lpa_data.fakes.mockedWawaCardBalance
import com.abrahamcardenes.lpa_data.fakes.mockedWawaCardBalanceEntity
import com.abrahamcardenes.lpa_data.jsons.concessionsResponse
import com.abrahamcardenes.lpa_data.jsons.ogs.ogWawaCardBalanceJson
import com.abrahamcardenes.lpa_data.jsons.shortLine10Timetable
import com.abrahamcardenes.lpa_data.remote.apis.ApiTravellers
import com.abrahamcardenes.lpa_data.utils.ServerMocks
import com.abrahamcardenes.lpa_domain.models.travellers.BusTimetables
import com.abrahamcardenes.lpa_domain.models.travellers.Concession
import com.abrahamcardenes.lpa_domain.models.travellers.ConcessionSchedule
import com.abrahamcardenes.lpa_domain.models.travellers.ConcessionStop
import com.abrahamcardenes.lpa_domain.models.travellers.RoutePaths
import com.abrahamcardenes.lpa_domain.models.travellers.TimetableInfo
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TravellersRepositoryImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiTravellers: ApiTravellers
    private val dateProvider = mockk<DateProvider>(relaxed = true)
    private val wawaBalanceDao = mockk<WawaBalanceDao>(relaxed = true)
    private lateinit var repository: TravellersRepositoryImpl

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiTravellers = ServerMocks.buildApiTravellersService(mockWebServer = mockWebServer)
        repository = TravellersRepositoryImpl(
            api = apiTravellers,
            dateProvider = dateProvider,
            wawaBalanceDao = wawaBalanceDao

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

    @Test
    fun `Given a call to save a card it should be mapped to entity and call the dao`() = runTest {
        val expectedEntity = mockedWawaCardBalanceEntity()
        repository.saveCard(mockedWawaCardBalance())
        coVerify {
            wawaBalanceDao.updateOrInsert(expectedEntity)
        }
    }

    @Test
    fun `Given a call to delete a card it should call the dao`() = runTest {
        repository.deleteCard(mockedWawaCardBalance())
        coVerify {
            wawaBalanceDao.deleteWawaBalanceByCode(mockedWawaCardBalance().code)
        }
    }

    @Test
    fun `Given a call to get all cards it should call the dao and return some cards mapped to domain model`() = runTest {
        coEvery {
            wawaBalanceDao.getAllWawaBalances()
        } returns flow {
            emit(listOf(mockedWawaCardBalanceEntity()))
        }

        val resultDbConvertedToSingle = repository.getAllCardsFromDb().single()

        assertThat(resultDbConvertedToSingle).isEqualTo(listOf(mockedWawaCardBalance()))

        coVerify {
            wawaBalanceDao.getAllWawaBalances()
        }
    }
}
