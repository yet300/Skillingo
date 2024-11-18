package com.hadj.skillingo.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.hadj.skillingo.root.RootComponent
import com.hadj.skillingo.screens.onboarding.OnBoardingScreen

@Composable
fun RootScreen(
    modifier: Modifier = Modifier,
    component: RootComponent,
) {
    val childStack by component.childStack.subscribeAsState()
    Children(
        stack = childStack,
        animation = stackAnimation(slide())
    ) { child ->
        when (val instance = child.instance) {

            is RootComponent.Child.Home -> {
                HomeScreen(modifier)
            }

            is RootComponent.Child.Onboarding -> {
                OnBoardingScreen(
                    modifier,
                    component = instance.component
                )
            }
        }
    }
}