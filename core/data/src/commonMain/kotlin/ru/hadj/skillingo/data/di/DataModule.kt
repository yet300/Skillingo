package ru.hadj.skillingo.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.hadj.database.di.databaseModule
import ru.hadj.skillingo.data.implementation.LocalOnBoardingImpl
import ru.hadj.skillingo.data.implementation.TaskGroupRepositoryImpl
import ru.hadj.skillingo.data.implementation.TaskRepositoryImpl
import ru.hadj.skillingo.data.implementation.ThemeModeRepositoryImpl
import ru.hadj.skillingo.domain.repository.LocalOnBoarding
import ru.hadj.skillingo.domain.repository.ThemeModeRepository


val dataModule = module {
    singleOf(::TaskRepositoryImpl)
    singleOf(::TaskGroupRepositoryImpl)

    single<ThemeModeRepository> {
        ThemeModeRepositoryImpl(get())
    }
    single<LocalOnBoarding> { LocalOnBoardingImpl(get()) }
} + databaseModule