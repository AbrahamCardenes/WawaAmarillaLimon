package com.abrahamcardenes.core_android.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.abrahamcardenes.core_android.firebase.CrashlyticsService
import javax.inject.Inject
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class WawaSettingsDataStore @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val crashlyticsService: CrashlyticsService
) : WawaSettings {
    private val etagKey = stringPreferencesKey("E_TAG")

    override suspend fun saveEtag(etag: Etag) {
        dataStore.edit { preferences ->
            preferences[etagKey] = etag
        }
    }

    override suspend fun getEtag(): Etag? = try {
        dataStore.data.map { preferences ->
            preferences[etagKey]
        }.firstOrNull()
    } catch (e: Exception) {
        crashlyticsService.logException(e)
        null
    }
}
