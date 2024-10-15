package com.hadj.skillingo.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.*
import ru.hadj.database.di.DataBaseModule
import ru.hadj.skillingo.data.di.DataModule


fun initKoin(config : KoinAppDeclaration ?= null) {
    startKoin {
        modules(
            DataModule().module,
            DataBaseModule().module,
        )
        config?.invoke(this)
    }
}