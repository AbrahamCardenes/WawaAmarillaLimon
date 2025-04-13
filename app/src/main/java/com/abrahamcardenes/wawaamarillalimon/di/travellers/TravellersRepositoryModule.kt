package com.abrahamcardenes.wawaamarillalimon.di.travellers

import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
import com.abrahamcardenes.wawaamarillalimon.data.TravellersRepositoryImpl
import com.abrahamcardenes.wawaamarillalimon.datasource.remote.apis.ApiTravellers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TravellersRepositoryModule {
    @Provides
    @Singleton
    fun provideTravellersRepository(api: ApiTravellers): TravellersRepository = TravellersRepositoryImpl(
        api = api
    )
}
