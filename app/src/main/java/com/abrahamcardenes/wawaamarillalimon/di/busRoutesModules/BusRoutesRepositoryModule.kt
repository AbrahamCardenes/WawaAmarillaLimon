package com.abrahamcardenes.wawaamarillalimon.di.busRoutesModules

import com.abrahamcardenes.wawaamarillalimon.BusRoutesRepositoryImpl
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiStaticApp
import com.abrahamcardenes.wawaamarillalimon.domain.BusRoutesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BusRoutesRepositoryModule {
    @Provides
    @Singleton
    fun provideTravellersRepository(api: ApiStaticApp): BusRoutesRepository = BusRoutesRepositoryImpl(
        apiService = api
    )
}
