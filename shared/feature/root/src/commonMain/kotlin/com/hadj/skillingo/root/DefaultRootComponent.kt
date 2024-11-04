package com.hadj.skillingo.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import com.hadj.skillingo.home.DefaultHomeComponent
import com.hadj.skillingo.onboarding.DefaultOnBoardingComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.hadj.skillingo.common.AppDispatchers
import ru.hadj.skillingo.domain.repository.LocalOnBoarding

class DefaultRootComponent(
    private val componentContext: ComponentContext,
) : RootComponent, KoinComponent, ComponentContext by componentContext {

    private val onBoarding by inject<LocalOnBoarding>()
    private val dispatchers by inject<AppDispatchers>()

    private val navigation = StackNavigation<Configuration>()


    private val stack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = if (onBoarding.read()) Configuration.HomeScreen else Configuration.OnboardingScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    override val childStack: Value<ChildStack<*, RootComponent.Child>>
        get() = stack

    private fun createChild(
        config: Configuration,
        componentContext: ComponentContext,
    ): RootComponent.Child = when (config) {
        Configuration.HomeScreen -> RootComponent.Child.Home(
            DefaultHomeComponent(
                componentContext = componentContext,
            )
        )

        Configuration.OnboardingScreen -> RootComponent.Child.Onboarding(
            DefaultOnBoardingComponent(
                componentContext = componentContext,
                //the entire navigation stack is replaced leaving only
                onNavigate = {
                    CoroutineScope(dispatchers.io).launch {
                        onBoarding.save(true)
                        navigation.replaceAll(Configuration.HomeScreen)
                    }
                }
            )
        )
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object OnboardingScreen : Configuration()

        @Serializable
        data object HomeScreen : Configuration()
    }

}