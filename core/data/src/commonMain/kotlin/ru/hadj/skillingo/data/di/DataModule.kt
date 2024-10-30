package ru.hadj.skillingo.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.hadj.database.di.databaseModule
import ru.hadj.skillingo.data.implementation.TaskGroupRepositoryImpl
import ru.hadj.skillingo.data.implementation.TaskRepositoryImpl


val dataModule = module {
    singleOf(::TaskRepositoryImpl)
    singleOf(::TaskGroupRepositoryImpl)
} + databaseModule