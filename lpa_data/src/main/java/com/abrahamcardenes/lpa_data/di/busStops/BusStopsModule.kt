package com.abrahamcardenes.lpa_data.di.busStops

import com.abrahamcardenes.lpa_data.BuildConfig
import com.abrahamcardenes.lpa_data.annotations.StopsRetrofit
import com.abrahamcardenes.lpa_data.remote.apis.ApiParadas
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object BusStopsModule {
    @Provides
    @Singleton
    @StopsRetrofit
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi =
            Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_PARADAS)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(@StopsRetrofit retrofit: Retrofit): ApiParadas = retrofit.create(ApiParadas::class.java)
}
