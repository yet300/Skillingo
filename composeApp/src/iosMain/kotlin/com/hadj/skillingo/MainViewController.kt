package com.hadj.skillingo

import androidx.compose.ui.window.ComposeUIViewController
import com.hadj.skillingo.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}