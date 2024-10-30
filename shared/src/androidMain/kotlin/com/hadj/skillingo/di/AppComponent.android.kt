package com.hadj.skillingo.di

import ru.hadj.skillingo.common.PlatformContext

internal actual fun createAppComponent(platformContext: PlatformContext): AppComponent {
    return AppComponent::class.create(platformContext)
}