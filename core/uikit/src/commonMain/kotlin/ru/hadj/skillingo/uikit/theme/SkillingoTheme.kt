package ru.hadj.skillingo.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.colorResource

@Composable
private fun DarkColorScheme() = darkColorScheme(
    background = colorResource(Res.colors.background_dark),
    primary = colorResource(Res.colors.primary_dark),
    secondary = colorResource(Res.colors.secondary_dark),
    tertiary = colorResource(Res.colors.tertiary_dark),
    error = colorResource(Res.colors.error_dark),
    surface = colorResource(Res.colors.surface_dark),
    onSurface = colorResource(Res.colors.on_surface_dark)
)

@Composable
private fun LightColorScheme() = lightColorScheme(
    background = colorResource(Res.colors.background_light),
    primary = colorResource(Res.colors.primary_light),
    secondary = colorResource(Res.colors.secondary_light),
    tertiary = colorResource(Res.colors.tertiary_light),
    error = colorResource(Res.colors.error_light),
    surface = colorResource(Res.colors.surface_light),
    onSurface = colorResource(Res.colors.on_surface_light)
)

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