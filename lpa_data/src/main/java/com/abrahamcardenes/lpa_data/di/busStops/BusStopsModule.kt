package com.abrahamcardenes.lpa_data.di.busStops

import com.abrahamcardenes.lpa_data.BuildConfig
import com.abrahamcardenes.lpa_data.annotations.StopsRetrofit
import com.abrahamcardenes.lpa_data.remote.apis.ApiParadas
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object BusStopsModule {
    @Provides
    @Singleton
    @StopsRetrofit
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        val converterFactory = json.asConverterFactory("application/json".toMediaType())
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_PARADAS)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(@StopsRetrofit retrofit: Retrofit): ApiParadas = retrofit.create(ApiParadas::class.java)
}
