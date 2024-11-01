package ru.hadj.skillingo.common.di

import org.koin.dsl.module
import ru.hadj.skillingo.common.AppDispatchers

val commonModule = module {
    single { AppDispatchers() }
}