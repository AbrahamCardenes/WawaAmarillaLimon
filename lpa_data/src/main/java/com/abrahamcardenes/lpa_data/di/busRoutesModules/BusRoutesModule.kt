package com.abrahamcardenes.lpa_data.di.busRoutesModules

import com.abrahamcardenes.lpa_data.BuildConfig
import com.abrahamcardenes.lpa_data.annotations.BusRoutesRetrofit
import com.abrahamcardenes.lpa_data.remote.apis.ApiStaticApp
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
object BusRoutesModule {
    @Provides
    @Singleton
    @BusRoutesRetrofit
    fun provideBusRoutesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        val converterFactory = json.asConverterFactory("application/json".toMediaType())
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_STATICAPP)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiStaticApp(@BusRoutesRetrofit retrofit: Retrofit): ApiStaticApp = retrofit.create(ApiStaticApp::class.java)
}
