package ru.hadj.skillingo.uikit.theme.color

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.colorResource

@Composable
internal fun LightColorScheme() = lightColorScheme(
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