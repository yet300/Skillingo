package ru.hadj.skillingo.data.implementation

import PomodoroTimer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import ru.hadj.skillingo.domain.controller.TimerController
import ru.hadj.skillingo.domain.model.SessionState
import ru.hadj.skillingo.domain.repository.PomodoroRepository
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

// TimerControllerImpl handles the timer logic and state management
class TimerControllerImpl(
    private val repository: PomodoroRepository,
    private val defaultWorkDuration: Duration = 25.minutes,
    private val defaultBreakDuration: Duration = 5.minutes
) : TimerController {

    private val _timeLeft = MutableStateFlow(defaultWorkDuration.inWholeSeconds)
    override val timeLeft: StateFlow<Long> = _timeLeft.asStateFlow()

    private val _isRunning = MutableStateFlow(false)
    override val isRunning: StateFlow<Boolean> = _isRunning.asStateFlow()

    private val _isWorkPhase = MutableStateFlow(true)
    override val isWorkPhase: StateFlow<Boolean> = _isWorkPhase.asStateFlow()

    private var timerJob: Job? = null
    private var customWorkDuration: Duration? = null
    private var customBreakDuration: Duration? = null

    override fun startTimer() {
        if (_isRunning.value) return

        timerJob?.cancel()
        timerJob = CoroutineScope(Dispatchers.Default).launch {
            _isRunning.value = true
            while (_timeLeft.value > 0 && _isRunning.value) {
                delay(1000)
                _timeLeft.value--

                if (_timeLeft.value <= 0) {
                    onSessionCompleted()
                }
            }
        }
    }

    override fun pauseTimer() {
        timerJob?.cancel()
        _isRunning.value = false
    }

    override fun resetTimer() {
        pauseTimer()
        _timeLeft.value = getCurrentDuration().inWholeSeconds
    }

    override fun switchPhase() {
        _isWorkPhase.value = !_isWorkPhase.value
        _timeLeft.value = getCurrentDuration().inWholeSeconds
        resetTimer()
    }

    override fun setCustomDurations(workDuration: Duration?, breakDuration: Duration?) {
        customWorkDuration = workDuration
        customBreakDuration = breakDuration
    }

    override fun onSessionCompleted() {
        // Логика завершения текущей сессии
        CoroutineScope(Dispatchers.Default).launch {
            val updatedTimer = repository.skipPhase()
            updateStateFromRepository(updatedTimer)
        }
    }

    override fun updateSessionType(type: SessionState) {
        // Это может быть обработка длинных перерывов или других фаз
    }

    private fun getCurrentDuration(): Duration {
        return if (_isWorkPhase.value) {
            customWorkDuration ?: defaultWorkDuration
        } else {
            customBreakDuration ?: defaultBreakDuration
        }
    }

    private fun updateStateFromRepository(timer: PomodoroTimer) {
        _timeLeft.value = timer.endTime?.epochSeconds?.minus(Clock.System.now().epochSeconds) ?: 0
        _isRunning.value = timer.isRunning
        _isWorkPhase.value = timer.isWorkPhase
    }
}