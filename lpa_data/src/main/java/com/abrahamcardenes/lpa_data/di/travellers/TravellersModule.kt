package com.abrahamcardenes.lpa_data.di.travellers

import com.abrahamcardenes.lpa_data.BuildConfig
import com.abrahamcardenes.lpa_data.annotations.TravellersRetrofit
import com.abrahamcardenes.lpa_data.remote.apis.ApiTravellers
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
object TravellersModule {
    @Provides
    @Singleton
    @TravellersRetrofit
    fun provideTravellersRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        val converterFactory = json.asConverterFactory("application/json".toMediaType())
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_TRAVELLERS)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiTravellersService(@TravellersRetrofit retrofit: Retrofit): ApiTravellers = retrofit.create(ApiTravellers::class.java)
}
