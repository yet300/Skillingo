package ru.hadj.skillingo.uikit.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SBottomBar(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
//    HorizontalDivider()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        content()
    }
}