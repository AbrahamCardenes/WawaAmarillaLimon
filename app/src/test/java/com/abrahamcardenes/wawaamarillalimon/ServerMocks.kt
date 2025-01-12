package com.abrahamcardenes.wawaamarillalimon

import com.abrahamcardenes.wawaamarillalimon.datasource.ApiParadas
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ServerMocks {

    private val client = OkHttpClient.Builder()
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

    fun buildApiParadasService(mockWebServer: MockWebServer): ApiParadas {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(ApiParadas::class.java)
    }
}