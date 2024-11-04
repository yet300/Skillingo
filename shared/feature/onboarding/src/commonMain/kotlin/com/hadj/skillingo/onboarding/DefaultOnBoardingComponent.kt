package com.hadj.skillingo.onboarding

import com.arkivanov.decompose.ComponentContext

class DefaultOnBoardingComponent(
    private val componentContext: ComponentContext,
    private val onNavigate: () -> Unit
) : OnBoardingComponent, ComponentContext by componentContext {

    override fun onClick() = onNavigate()

}