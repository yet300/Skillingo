package com.hadj.skillingo.onboarding

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.hadj.skillingo.common.AppDispatchers
import ru.hadj.skillingo.domain.model.ThemeMode
import ru.hadj.skillingo.domain.repository.ThemeModeRepository

class DefaultOnBoardingComponent(
    private val componentContext: ComponentContext,
    private val onNavigate: () -> Unit
) : OnBoardingComponent, KoinComponent, ComponentContext by componentContext {

    private val themeModeRepository by inject<ThemeModeRepository>()
    private val dispatchers by inject<AppDispatchers>()

    private val _model = MutableValue(
        OnBoardingComponent.Model()
    )
    override val model: Value<OnBoardingComponent.Model> = _model

    init {
        CoroutineScope(dispatchers.io).launch {
            themeModeRepository.readThemeMode().collect { themeMode ->
                _model.value = _model.value.copy(currentThemeMode = themeMode)
            }
        }
    }

    override suspend fun changeThemeMode(themeMode: ThemeMode) {
        withContext(dispatchers.io) {
            themeModeRepository.saveThemeMode(themeMode)
            _model.value = _model.value.copy(currentThemeMode = themeMode)
        }
    }

    override fun nextPage() {
        val currentPage = _model.value.currentPage
        if (currentPage < _model.value.totalPages - 1) {
            _model.value = _model.value.copy(currentPage = currentPage + 1)
        } else {
            onClick()
        }
    }

    override fun onClick() = onNavigate()

}