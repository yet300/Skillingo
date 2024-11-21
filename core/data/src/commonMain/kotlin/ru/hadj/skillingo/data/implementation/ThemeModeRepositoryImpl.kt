package ru.hadj.skillingo.data.implementation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.hadj.database.store.ThemeModeDataStore
import ru.hadj.skillingo.data.mapper.toThemeMode
import ru.hadj.skillingo.data.mapper.toThemeModeDBO
import ru.hadj.skillingo.domain.model.ThemeMode
import ru.hadj.skillingo.domain.repository.ThemeModeRepository

class ThemeModeRepositoryImpl(
    private val themeModeDataStore: ThemeModeDataStore,
) : ThemeModeRepository {
    override fun readThemeMode(): Flow<ThemeMode> {
        return themeModeDataStore.readThemeMode().map { it.toThemeMode() }
    }

    override suspend fun saveThemeMode(themeMode: ThemeMode) {
        themeModeDataStore.saveThemeMode(themeMode.toThemeModeDBO())
    }
}