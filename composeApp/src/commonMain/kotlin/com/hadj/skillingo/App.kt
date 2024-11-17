package com.hadj.skillingo

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.hadj.skillingo.root.RootComponent
import com.hadj.skillingo.screens.RootScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.hadj.skillingo.uikit.theme.Theme

@Composable
@Preview
fun App(component: RootComponent) {
    Theme {
        Surface {
            RootScreen(
                component = component,
            )
        }
    }
}