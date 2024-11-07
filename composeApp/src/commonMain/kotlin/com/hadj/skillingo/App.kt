package com.hadj.skillingo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hadj.skillingo.root.RootComponent
import com.hadj.skillingo.screens.RootScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.hadj.skillingo.uikit.theme.SkillingoTheme

@Composable
@Preview
fun App(component: RootComponent) {
    SkillingoTheme {
        Scaffold(
//            topBar = {
//                CenterAlignedTopAppBar(
//                    title = {
//                        Text(
//                            "Skilingo",
//                            color = MaterialTheme.colorScheme.secondary,
//                            style = MaterialTheme.typography.bodyMedium
//                        )
//                    }
//                )
//            },
            content = { innerPadding ->
                RootScreen(
                    component = component,
                    modifier = Modifier.padding(innerPadding)
                )
            },
//            bottomBar = {
//                BottomAppBar {
//                    Text(
//                        "Bottom bar",
//                        style = MaterialTheme.typography.bodyMedium,
//                        modifier = Modifier.align(
//                            Alignment.Bottom
//                        )
//                    )
//                }
//            }
        )
    }
}