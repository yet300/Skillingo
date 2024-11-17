package ru.hadj.skillingo.uikit.component.timer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Composable
fun rememberTimerController(
    workDuration: Int = 25,
    breakDuration: Int = 5
): TimerController {
    return rememberSaveable(saver = TimerController.Saver(workDuration, breakDuration)) {
        TimerController(workDuration, breakDuration)
    }
}

class TimerController(
    private val workDuration: Int,
    private val breakDuration: Int
) {
    private val _timeLeft = MutableStateFlow(workDuration * 60)
    val timeLeft = _timeLeft.asStateFlow()

    private val _isRunning = MutableStateFlow(false)
    val isRunning = _isRunning.asStateFlow()

    private val _isWorkPhase = MutableStateFlow(true)
    val isWorkPhase = _isWorkPhase.asStateFlow()

    private var timerJob: Job? = null

    fun startTimer() {
        if (_isRunning.value) return
        timerJob?.cancel()
        timerJob = CoroutineScope(Dispatchers.Default).launch {
            _isRunning.value = true
            while (_isRunning.value && _timeLeft.value > 0) {
                delay(1000)
                _timeLeft.value--

                if (_timeLeft.value <= 0) {
                    switchPhase()
                }
            }
        }
    }

    fun pauseTimer() {
        timerJob?.cancel()
        _isRunning.value = false
    }

    fun resetTimer() {
        timerJob?.cancel()
        _isRunning.value = false
        _timeLeft.value = if (_isWorkPhase.value) workDuration * 60 else breakDuration * 60
        startTimer()
    }

    fun switchPhase() {
        timerJob?.cancel()
        _isWorkPhase.value = !_isWorkPhase.value
        _timeLeft.value = if (_isWorkPhase.value) workDuration * 60 else breakDuration * 60
        _isRunning.value = false
        startTimer()
    }

    companion object {
        fun Saver(workDuration: Int, breakDuration: Int): Saver<TimerController, *> = Saver(
            save = { controller ->
                listOf(
                    controller._timeLeft.value,
                    controller._isRunning.value,
                    controller._isWorkPhase.value
                )
            },
            restore = { state ->
                TimerController(workDuration, breakDuration).apply {
                    _timeLeft.value = state[0] as Int
                    _isRunning.value = state[1] as Boolean
                    _isWorkPhase.value = state[2] as Boolean
                }
            }
        )
    }
}