package com.abrahamcardenes.wawaamarillalimon

import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServerMocks {
    private val client =
        OkHttpClient
            .Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()

    fun enqueue(mockWebServer: MockWebServer, code: Int, body: String) {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(code)
                .setBody(body)
        )
    }

    fun buildApiParadasService(mockWebServer: MockWebServer): ApiParadas = Retrofit
        .Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .baseUrl(mockWebServer.url("/"))
        .build()
        .create(ApiParadas::class.java)

    fun buildApiTravellersService(mockWebServer: MockWebServer): ApiTravellers = Retrofit
        .Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .baseUrl(mockWebServer.url("/"))
        .build()
        .create(ApiTravellers::class.java)

    fun buildApiStaticAppService(mockWebServer: MockWebServer): ApiStaticApp = Retrofit
        .Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .baseUrl(mockWebServer.url("/"))
        .build()
        .create(ApiStaticApp::class.java)
}
