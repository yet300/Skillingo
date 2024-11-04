package com.hadj.skillingo.home

import com.arkivanov.decompose.ComponentContext

class DefaultHomeComponent(
    private val componentContext: ComponentContext,
) : HomeComponent, ComponentContext by componentContext