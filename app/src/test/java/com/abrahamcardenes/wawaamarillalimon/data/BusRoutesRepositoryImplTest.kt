package com.abrahamcardenes.wawaamarillalimon.data

import com.abrahamcardenes.wawaamarillalimon.ServerMocks
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import com.abrahamcardenes.wawaamarillalimon.jsons.concessionsResponse
import com.google.common.truth.Truth.assertThat
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
        ServerMocks.enqueue(
            code = 200,
            body = shortStaticAppBusLine13,
            mockWebServer = mockWebServer
        )
        val result = repository.getBusRoutes(busNumber = "13")
        println(result)
    }
}