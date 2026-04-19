package com.abrahamcardenes.lpa_data.di.busStops

import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import com.abrahamcardenes.core_android.di.ApplicationScope
import com.abrahamcardenes.core_db.BusStopDao
import com.abrahamcardenes.lpa_data.data.BusStopsRepositoryImpl
import com.abrahamcardenes.lpa_data.remote.apis.ApiParadas
import com.abrahamcardenes.lpa_domain.repositories.BusStopsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(SingletonComponent::class)
object BusStopsRepositoryModule {
    @Provides
    @Singleton
    fun provideBusStopsRepository(
        api: ApiParadas,
        dao: BusStopDao,
        @ApplicationScope applicationScope: CoroutineScope,
        dispatchersProvider: DispatchersProvider
    ): BusStopsRepository = BusStopsRepositoryImpl(
        api = api,
        busStopDao = dao,
        coroutineScope = applicationScope,
        dispatchersProvider = dispatchersProvider
    )
}
