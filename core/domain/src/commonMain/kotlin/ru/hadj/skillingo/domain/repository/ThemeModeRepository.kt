package ru.hadj.skillingo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.domain.model.ThemeMode

interface ThemeModeRepository {
    fun readThemeMode(): Flow<ThemeMode>
    suspend fun saveThemeMode(themeMode: ThemeMode)
}