package ru.hadj.skillingo.domain.di

import org.koin.dsl.module
import ru.hadj.skillingo.domain.usecase.PomodoroUseCase

val domainModule = module {
    single {
        PomodoroUseCase(
            repository = get(),
            timerController = get()
        )
    }
}