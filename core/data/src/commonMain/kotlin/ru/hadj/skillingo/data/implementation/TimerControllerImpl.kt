package ru.hadj.skillingo.data.implementation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.hadj.skillingo.domain.controller.TimerController

// TimerControllerImpl handles the timer logic and state management
class TimerControllerImpl : TimerController {
    private val _timeLeft = MutableStateFlow(0L)
    override val timeLeft: Flow<Long> = _timeLeft

    private val _isRunning = MutableStateFlow(false)
    override val isRunning: StateFlow<Boolean> = _isRunning

    private var job: Job? = null
    private var remainingMillis: Long = 0L

    override fun start(durationMillis: Long) {
        job?.cancel()
        remainingMillis = durationMillis
        _isRunning.value = true
        job = CoroutineScope(Dispatchers.Default).launch {
            while (remainingMillis > 0) {
                delay(1000)
                remainingMillis -= 1000
                _timeLeft.value = remainingMillis
            }
            _isRunning.value = false
        }
    }

    override fun pause() {
        job?.cancel()
        _isRunning.value = false
    }

    override fun resume() {
        if (remainingMillis > 0) {
            _isRunning.value = true
            job = CoroutineScope(Dispatchers.Default).launch {
                while (remainingMillis > 0) {
                    delay(1000)
                    remainingMillis -= 1000
                    _timeLeft.value = remainingMillis
                }
                _isRunning.value = false
            }
        }
    }

    override fun reset() {
        job?.cancel()
        remainingMillis = 0L
        _timeLeft.value = 0L
        _isRunning.value = false
    }
}