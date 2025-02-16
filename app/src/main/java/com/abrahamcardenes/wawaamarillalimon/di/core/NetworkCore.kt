package com.abrahamcardenes.wawaamarillalimon.di.core

import com.abrahamcardenes.wawaamarillalimon.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object NetworkCore {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptorLogLevel =
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }

        val loggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = interceptorLogLevel
            }

        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
}
