package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.ServerMocks
import com.abrahamcardenes.wawaamarillalimon.core.Result
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import com.abrahamcardenes.wawaamarillalimon.fakes.mockedConcessions
import com.abrahamcardenes.wawaamarillalimon.jsons.concessionsResponse
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
            mockedConcessions()
        )

        ServerMocks.enqueue(
            code = 200,
            body = concessionsResponse,
            mockWebServer = mockWebServer
        )

        val result = repository.getConcessions()

        assertThat(result).isEqualTo(expected)
    }
}
