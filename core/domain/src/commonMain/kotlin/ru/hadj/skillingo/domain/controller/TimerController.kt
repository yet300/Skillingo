package ru.hadj.skillingo.domain.controller

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface TimerController {
    fun start(durationMillis: Long)
    fun pause()
    fun resume()
    fun reset()
    val timeLeft: Flow<Long>
    val isRunning: StateFlow<Boolean>
}