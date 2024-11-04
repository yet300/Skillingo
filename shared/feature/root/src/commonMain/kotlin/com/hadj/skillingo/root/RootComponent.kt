package com.hadj.skillingo.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.hadj.skillingo.home.HomeComponent
import com.hadj.skillingo.onboarding.OnBoardingComponent

interface RootComponent {

    val childStack: Value<ChildStack<*, Child>>


    sealed class Child {
        data class Onboarding(val component: OnBoardingComponent) : Child()
        data class Home(val component: HomeComponent) : Child()
    }
}