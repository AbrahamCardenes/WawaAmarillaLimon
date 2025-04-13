package com.abrahamcardenes.lpa_data.di.travellers

import com.abrahamcardenes.lpa_data.data.TravellersRepositoryImpl
import com.abrahamcardenes.lpa_data.remote.apis.ApiTravellers
import com.abrahamcardenes.lpa_domain.repositories.TravellersRepository
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
