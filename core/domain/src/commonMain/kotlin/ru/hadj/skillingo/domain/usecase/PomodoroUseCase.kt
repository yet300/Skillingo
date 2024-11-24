package ru.hadj.skillingo.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.domain.controller.TimerController
import ru.hadj.skillingo.domain.model.SessionState
import ru.hadj.skillingo.domain.repository.PomodoroRepository
import kotlin.time.Duration.Companion.minutes

class PomodoroUseCase(
    private val repository: PomodoroRepository,
    private val timerController: TimerController
) {
    private val pomodoroModes = listOf(
        SessionState.FOCUS to 25.minutes,
        SessionState.BREAK to 5.minutes,
        SessionState.LONG_BREAK to 30.minutes
    )

    private var currentModeIndex = 0

    fun startPomodoro() {
        val duration = pomodoroModes[currentModeIndex]
        timerController.start(duration.second.inWholeMilliseconds)
    }

    fun pausePomodoro() = timerController.pause()

    fun resumePomodoro() = timerController.resume()

    fun skipToNextMode() {
        currentModeIndex = (currentModeIndex + 1) % pomodoroModes.size
        startPomodoro()
    }

    fun resetPomodoro() {
        currentModeIndex = 0
        timerController.reset()
    }

    fun observeTimeLeft(): Flow<Long> = timerController.timeLeft

    fun isTimerRunning(): Flow<Boolean> = timerController.isRunning

    suspend fun savePomodoroCompletion() {
        val completedMode = pomodoroModes[currentModeIndex].first
        repository.updateDailyGoal(id = currentModeIndex.toLong(), goal = 1)
    }
}