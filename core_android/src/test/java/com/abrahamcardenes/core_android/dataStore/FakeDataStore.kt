package com.abrahamcardenes.core_android.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.mutablePreferencesOf
import kotlinx.coroutines.flow.flow

class FakeDataStore : DataStore<Preferences> {
    private var state: Preferences = mutablePreferencesOf()

    override val data = flow {
        emit(state)
    }

    override suspend fun updateData(transform: suspend (value: Preferences) -> Preferences): Preferences {
        state = transform(state)
        return state
    }
}
