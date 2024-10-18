package com.hadj.skillingo.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.*


fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        modules(
            AppModule().module
        )
        config?.invoke(this)
    }
}