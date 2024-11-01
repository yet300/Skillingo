package com.hadj.skillingo.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import ru.hadj.skillingo.common.di.commonModule
import ru.hadj.skillingo.data.di.dataModule

fun allModules() = listOf(commonModule) + dataModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        modules(
            allModules()
        )
        config?.invoke(this)
    }
}