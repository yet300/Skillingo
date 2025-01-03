package ru.hadj.skillingo.uikit.theme.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import ru.hadj.skillingo.uikit.theme.color.DarkColorScheme
import ru.hadj.skillingo.uikit.theme.color.LightColorScheme

@Composable
fun SkillingoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val autoColors = if (darkTheme) DarkColorScheme() else LightColorScheme()
    MaterialTheme(
        colorScheme = autoColors,
        typography = SkillingoTypography(),
        content = content,
    )
}