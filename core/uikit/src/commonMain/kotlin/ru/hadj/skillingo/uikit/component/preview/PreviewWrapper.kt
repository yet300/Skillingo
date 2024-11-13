package ru.hadj.skillingo.uikit.component.preview

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import ru.hadj.skillingo.uikit.theme.SkillingoTheme

@Composable
fun SkillingoPreviewWrapper(content: @Composable () -> Unit) {
    SkillingoTheme {
        Surface(
            content = content
        )
    }
}