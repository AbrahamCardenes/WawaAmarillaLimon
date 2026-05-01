package com.abrahamcardenes.lpa_data.di.busStops

import com.abrahamcardenes.core_android.dataStore.WawaSettings
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.lpa_data.data.BusStopsRepositoryImpl
import com.abrahamcardenes.lpa_data.remote.apis.ApiParadas
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
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
    fun provideBusStopsRepository(
        api: ApiParadas,
        dao: BusStopDao,
        crashlyticsService: CrashlyticsService,
        wawaSettings: WawaSettings
    ): BusStopsRepository = BusStopsRepositoryImpl(
        api = api,
        busStopDao = dao,
        crashlyticsService = crashlyticsService,
        wawaSettings = wawaSettings
    )
}
