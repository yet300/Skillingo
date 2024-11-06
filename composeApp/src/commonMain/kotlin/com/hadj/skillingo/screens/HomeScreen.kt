package com.hadj.skillingo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.error
        )

        Text(
            text = "MAGA",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "secondary and displayMedium ",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.secondary
        )

        Text(
            text = "tertiary and bodyLarge ",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.tertiary
        )

        Text(text = "surface ", color = MaterialTheme.colorScheme.surface)

        Text(text = "onSurface ", color = MaterialTheme.colorScheme.onSurface)
    }
}