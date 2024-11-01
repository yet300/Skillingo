package ru.hadj.database.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnBoardingDataStore(private val dataStore: DataStore<Preferences>) {

    // Define preference keys
    private object PreferencesKeys {
        val ON_BOARDING_COMPLETED = booleanPreferencesKey("on_boarding_completed")
    }

    // Save onboarding state
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.ON_BOARDING_COMPLETED] = completed
        }
    }

    // Read onboarding state
    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[PreferencesKeys.ON_BOARDING_COMPLETED] ?: false
        }
    }
}