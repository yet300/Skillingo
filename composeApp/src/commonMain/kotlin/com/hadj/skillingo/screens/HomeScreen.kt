package com.hadj.skillingo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        item {
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.secondary,
                typography = MaterialTheme.typography.displayMedium,
                text = "Secondary - Display Medium"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.tertiary,
                typography = MaterialTheme.typography.bodyLarge,
                text = "Tertiary - Body Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.error,
                typography = MaterialTheme.typography.titleMedium,
                text = "Error - Title Medium"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.primary,
                typography = MaterialTheme.typography.displayLarge,
                text = "Primary - Display Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.background,
                typography = MaterialTheme.typography.headlineSmall,
                text = "Background - Headline Small"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.surface,
                typography = MaterialTheme.typography.headlineMedium,
                text = "Surface - Headline Medium"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.outline,
                typography = MaterialTheme.typography.headlineLarge,
                text = "Outline - Headline Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onBackground,
                typography = MaterialTheme.typography.titleSmall,
                text = "On Background - Title Small"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onSurface,
                typography = MaterialTheme.typography.titleLarge,
                text = "On Surface - Title Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onPrimary,
                typography = MaterialTheme.typography.titleSmall,
                text = "On Primary - Title Small"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onSecondary,
                typography = MaterialTheme.typography.titleLarge,
                text = "On Secondary - Title Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onTertiary,
                typography = MaterialTheme.typography.titleMedium,
                text = "On Tertiary - Title Medium"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                typography = MaterialTheme.typography.titleSmall,
                text = "On Tertiary Container - Title Small"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                typography = MaterialTheme.typography.titleLarge,
                text = "On Primary Container - Title Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                typography = MaterialTheme.typography.titleMedium,
                text = "On Secondary Container - Title Medium"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                typography = MaterialTheme.typography.titleSmall,
                text = "On Surface Variant - Title Small"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                typography = MaterialTheme.typography.titleLarge,
                text = "On Surface Variant - Title Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                typography = MaterialTheme.typography.titleMedium,
                text = "Inverse On Surface - Title Medium"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.inverseSurface,
                typography = MaterialTheme.typography.titleSmall,
                text = "Inverse Surface - Title Small"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.inversePrimary,
                typography = MaterialTheme.typography.titleLarge,
                text = "Inverse Primary - Title Large"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.surfaceTint,
                typography = MaterialTheme.typography.titleMedium,
                text = "Surface Tint - Title Medium"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.surfaceVariant,
                typography = MaterialTheme.typography.titleSmall,
                text = "Surface Variant - Title Small"
            )
            ThemeColorCombination(
                color = MaterialTheme.colorScheme.surfaceVariant,
                typography = MaterialTheme.typography.titleLarge,
                text = "Surface Variant - Title Large"
            )
        }
    }
}

@Composable
private fun ThemeColorCombination(
    color: Color,
    typography: TextStyle,
    text: String
) {
    Text(
        text = text,
        style = typography,
        color = color
    )
}