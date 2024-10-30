package com.hadj.skillingo

import android.app.Application


class SkillingoApp @JvmOverloads constructor(
    private val platform: SkillingoAppPlatform = SkillingoAppPlatform()
) : Application()   {

    override fun onCreate() {
        super.onCreate()
        platform.start(
            platformContext = this
        )
    }
}