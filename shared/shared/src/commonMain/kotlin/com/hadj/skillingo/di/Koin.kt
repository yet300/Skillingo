package com.hadj.skillingo.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import ru.hadj.skillingo.common.di.commonModule
import ru.hadj.skillingo.data.di.dataModule
import ru.hadj.skillingo.domain.di.domainModule

fun allModules() = listOf(commonModule) + dataModule + domainModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        modules(
            allModules()
        )
        config?.invoke(this)
    }
}