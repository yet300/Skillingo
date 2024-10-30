package com.hadj.skillingo

import com.hadj.skillingo.di.AppComponent
import ru.hadj.skillingo.common.PlatformContext
import kotlin.properties.Delegates.notNull

class SkillingoAppPlatform {

    var appComponent: AppComponent by notNull()
        private set

    fun start(
        platformContext: PlatformContext,
    ) {
        appComponent = AppComponent.create(
            platformContext
        )
    }
}