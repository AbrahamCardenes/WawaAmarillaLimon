package com.abrahamcardenes.wawaamarillalimon

import android.app.Application
import com.abrahamcardenes.core.dispatchers.DispatchersProvider
import com.abrahamcardenes.core_android.dataStore.WawaSettingsDataStore
import com.abrahamcardenes.core_android.di.ApplicationScope
import com.abrahamcardenes.core_db.BusStopDao
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class WawaAmarillaLimon : Application() {
    @Inject
    lateinit var busStopDao: BusStopDao

    @Inject
    lateinit var dispatchersProvider: DispatchersProvider

    @Inject
    @ApplicationScope
    lateinit var applicationScope: CoroutineScope

    @Inject
    lateinit var dataStore: WawaSettingsDataStore

    override fun onCreate() {
        super.onCreate()
        // pre-warm Room
        applicationScope.launch(dispatchersProvider.IO) {
            busStopDao.getBusStops()
            dataStore.getEtag()
        }
    }
}
