package ru.hadj.skillingo.uikit.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.colorResource

@Composable
internal fun DarkColorScheme() = darkColorScheme(
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

