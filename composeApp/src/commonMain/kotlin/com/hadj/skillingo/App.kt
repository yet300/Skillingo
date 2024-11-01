package com.hadj.skillingo

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.hadj.skillingo.root.RootComponent
import com.hadj.skillingo.screens.RootScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(component: RootComponent) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Skilingo",
                            color = MaterialTheme.colors.onPrimary,
                            style = MaterialTheme.typography.h3
                        )
                    }
                )
            },
            content = {
                RootScreen(
                    component = component
                )
            },
            bottomBar = { Text("Bottom bar") }
        )
    }
}