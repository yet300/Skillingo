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
    primary = colorResource(Res.colors.dark_primary),
    onPrimary = colorResource(Res.colors.dark_onPrimary),

    primaryContainer = colorResource(Res.colors.dark_primaryContainer),
    onPrimaryContainer = colorResource(Res.colors.dark_onPrimaryContainer),

    inversePrimary = colorResource(Res.colors.dark_inversePrimary),

    secondary = colorResource(Res.colors.dark_secondary),
    onSecondary = colorResource(Res.colors.dark_onSecondary),

    secondaryContainer = colorResource(Res.colors.dark_secondaryContainer),
    onSecondaryContainer = colorResource(Res.colors.dark_onSecondaryContainer),

    tertiary = colorResource(Res.colors.dark_tertiary),
    onTertiary = colorResource(Res.colors.dark_onTertiary),

    tertiaryContainer = colorResource(Res.colors.dark_tertiaryContainer),
    onTertiaryContainer = colorResource(Res.colors.dark_onTertiaryContainer),

    error = colorResource(Res.colors.dark_error),
    onError = colorResource(Res.colors.dark_onError),

    errorContainer = colorResource(Res.colors.dark_errorContainer),
    onErrorContainer = colorResource(Res.colors.dark_onErrorContainer),

    background = colorResource(Res.colors.dark_background),
    onBackground = colorResource(Res.colors.dark_onBackground),

    surface = colorResource(Res.colors.dark_surface),
    onSurface = colorResource(Res.colors.dark_onSurface),

    surfaceVariant = colorResource(Res.colors.dark_surfaceVariant),
    onSurfaceVariant = colorResource(Res.colors.dark_onSurfaceVariant),

    outline = colorResource(Res.colors.dark_outline),

    inverseOnSurface = colorResource(Res.colors.dark_inverseOnSurface),
    inverseSurface = colorResource(Res.colors.dark_inverseSurface),

    surfaceTint = colorResource(Res.colors.dark_surfaceTint),
)

@Composable
private fun LightColorScheme() = lightColorScheme(
    primary = colorResource(Res.colors.light_primary),
    onPrimary = colorResource(Res.colors.light_onPrimary),

    primaryContainer = colorResource(Res.colors.light_primaryContainer),
    onPrimaryContainer = colorResource(Res.colors.light_onPrimaryContainer),

    inversePrimary = colorResource(Res.colors.light_inversePrimary),

    secondary = colorResource(Res.colors.light_secondary),
    onSecondary = colorResource(Res.colors.light_onSecondary),

    secondaryContainer = colorResource(Res.colors.light_secondaryContainer),
    onSecondaryContainer = colorResource(Res.colors.light_onSecondaryContainer),

    tertiary = colorResource(Res.colors.light_tertiary),
    onTertiary = colorResource(Res.colors.light_onTertiary),

    tertiaryContainer = colorResource(Res.colors.light_tertiaryContainer),
    onTertiaryContainer = colorResource(Res.colors.light_onTertiaryContainer),

    error = colorResource(Res.colors.light_error),
    onError = colorResource(Res.colors.light_onError),

    errorContainer = colorResource(Res.colors.light_errorContainer),
    onErrorContainer = colorResource(Res.colors.light_onErrorContainer),

    background = colorResource(Res.colors.light_background),
    onBackground = colorResource(Res.colors.light_onBackground),

    surface = colorResource(Res.colors.light_surface),
    onSurface = colorResource(Res.colors.light_onSurface),

    surfaceVariant = colorResource(Res.colors.light_surfaceVariant),
    onSurfaceVariant = colorResource(Res.colors.light_onSurfaceVariant),

    outline = colorResource(Res.colors.light_outline),

    inverseOnSurface = colorResource(Res.colors.light_inverseOnSurface),
    inverseSurface = colorResource(Res.colors.light_inverseSurface),

    surfaceTint = colorResource(Res.colors.light_surfaceTint),
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