package com.hadj.skillingo.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.hadj.skillingo.domain.repository.ThemeModeRepository

class RepositoryHelper : KoinComponent {
    private val themeModeRepository: ThemeModeRepository by inject()
    fun themeModeRepository() = themeModeRepository
}