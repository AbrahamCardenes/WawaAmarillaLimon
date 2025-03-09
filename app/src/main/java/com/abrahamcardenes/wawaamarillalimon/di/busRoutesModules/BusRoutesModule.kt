package com.abrahamcardenes.wawaamarillalimon.di.busRoutesModules

import com.abrahamcardenes.wawaamarillalimon.BuildConfig
import com.abrahamcardenes.wawaamarillalimon.annotations.BusRoutesRetrofit
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
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
object BusRoutesModule {
    @Provides
    @Singleton
    @BusRoutesRetrofit
    fun provideBusRoutesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi =
            Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.API_STATICAPP)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiStaticApp(@BusRoutesRetrofit retrofit: Retrofit): ApiStaticApp = retrofit.create(ApiStaticApp::class.java)
}
