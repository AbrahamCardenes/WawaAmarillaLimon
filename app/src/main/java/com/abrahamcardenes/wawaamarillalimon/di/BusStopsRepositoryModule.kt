package com.abrahamcardenes.wawaamarillalimon.di

import com.abrahamcardenes.wawaamarillalimon.data.BusStopsRepositoryImpl
import com.abrahamcardenes.wawaamarillalimon.datasource.ApiParadas
import com.abrahamcardenes.wawaamarillalimon.domain.BusStopsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BusStopsRepositoryModule {
    @Provides
    @Singleton
    fun provideBusStopsRepository(api: ApiParadas): BusStopsRepository = BusStopsRepositoryImpl(api)
}
