package com.abrahamcardenes.core_android.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.abrahamcardenes.core_android.dataStore.WawaSettings
import com.abrahamcardenes.core_android.dataStore.WawaSettingsDataStore
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "settings"
)

@Module
@InstallIn(SingletonComponent::class)
object DataStoreProviderModule {
    @Provides
    @Singleton
    fun provideWawaDataStore(@ApplicationContext context: Context): DataStore<Preferences> = context.dataStore

    @Provides
    @Singleton
    fun provideWawaSettingsDataStore(crashlyticsService: CrashlyticsService, dataStore: DataStore<Preferences>): WawaSettings =
        WawaSettingsDataStore(
            dataStore = dataStore,
            crashlyticsService = crashlyticsService
        )
}
