package ru.hadj.skillingo.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.koinInject
import ru.hadj.skillingo.domain.model.ThemeMode
import ru.hadj.skillingo.domain.repository.ThemeModeRepository
import ru.hadj.skillingo.uikit.theme.main.SkillingoTheme


@Composable
fun Theme(
    content: @Composable () -> Unit,
) {
    val themeModeRepository: ThemeModeRepository = koinInject()

    val themeMode by themeModeRepository.readThemeMode().collectAsState(initial = ThemeMode.SYSTEM)

    val isDarkTheme = when (themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }

    SkillingoTheme(content = content, darkTheme = isDarkTheme)
}
