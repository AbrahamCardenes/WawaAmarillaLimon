package com.abrahamcardenes.wawaamarillalimon.di.busRoutesModules

import com.abrahamcardenes.lpa_data.data.BusRoutesRepositoryImpl
import com.abrahamcardenes.lpa_data.remote.apis.ApiStaticApp
import com.abrahamcardenes.lpa_domain.repositories.BusRoutesRepository
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
