package ru.hadj.skillingo.domain.controller

import kotlinx.coroutines.flow.StateFlow
import ru.hadj.skillingo.domain.model.SessionState
import kotlin.time.Duration

interface TimerController {
    val timeLeft: StateFlow<Long>
    val isRunning: StateFlow<Boolean>
    val isWorkPhase: StateFlow<Boolean>

    fun startTimer()
    fun pauseTimer()
    fun resetTimer()
    fun switchPhase()
    fun setCustomDurations(workDuration: Duration?, breakDuration: Duration?)
    fun onSessionCompleted()
    fun updateSessionType(type: SessionState)
} 