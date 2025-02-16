package com.abrahamcardenes.wawaamarillalimon.di.travellers

import com.abrahamcardenes.wawaamarillalimon.BuildConfig
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object TravellersModule {
    @Provides
    @Singleton
    @Named("apiTravellers")
    fun provideTravellersRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi =
            Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_TRAVELLERS)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiTravellersService(@Named("apiTravellers") retrofit: Retrofit): ApiTravellers = retrofit.create(ApiTravellers::class.java)
}
