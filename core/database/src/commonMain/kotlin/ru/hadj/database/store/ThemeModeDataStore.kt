package ru.hadj.database.store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.hadj.database.model.ThemeModeDBO

class ThemeModeDataStore(
    private val dataStore: DataStore<Preferences>
) {
    fun readThemeMode(): Flow<ThemeModeDBO> = dataStore.data
        .map { preferences ->
            val modeValue = preferences[THEME_MODE_KEY] ?: ThemeModeDBO.SYSTEM.name
            ThemeModeDBO.valueOf(modeValue)
        }

    suspend fun saveThemeMode(themeMode: ThemeModeDBO) {
        dataStore.edit { preferences ->
            preferences[THEME_MODE_KEY] = themeMode.name
        }
    }

    companion object {
        private val THEME_MODE_KEY = stringPreferencesKey("theme_mode")
    }
}