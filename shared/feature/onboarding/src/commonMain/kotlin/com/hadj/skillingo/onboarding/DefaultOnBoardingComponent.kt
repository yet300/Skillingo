package com.hadj.skillingo.onboarding

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.hadj.skillingo.common.AppDispatchers
import ru.hadj.skillingo.domain.model.ThemeMode
import ru.hadj.skillingo.domain.repository.ThemeModeRepository
import ru.hadj.skillingo.domain.usecase.PomodoroUseCase

class DefaultOnBoardingComponent(
    private val componentContext: ComponentContext,
    private val onNavigate: () -> Unit
) : OnBoardingComponent, KoinComponent, ComponentContext by componentContext {

    private val pomodoroUseCase by inject<PomodoroUseCase>()
    private val themeModeRepository by inject<ThemeModeRepository>()
    private val dispatchers by inject<AppDispatchers>()
    private val _model = MutableValue(
        OnBoardingComponent.Model()
    )
    override val model: Value<OnBoardingComponent.Model> = _model

    init {
        CoroutineScope(dispatchers.io + SupervisorJob()).launch {
            themeModeRepository.readThemeMode().collect { themeMode ->
                _model.value = _model.value.copy(currentThemeMode = themeMode)
            }

            pomodoroUseCase.observeTimeLeft().collect { timeLeft ->
                _model.value = _model.value.copy(timeLeft = timeLeft)
            }

            pomodoroUseCase.isTimerRunning().collect { isRunning ->
                _model.value = _model.value.copy(isRunning = isRunning)
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

    override fun startTimer() {
        pomodoroUseCase.startPomodoro()
    }

    override fun pauseTimer() {
        pomodoroUseCase.pausePomodoro()
    }

    override fun resetTimer() {
        pomodoroUseCase.resetPomodoro()
    }

    override fun switchPhase() {
        pomodoroUseCase.skipToNextMode()
    }
}