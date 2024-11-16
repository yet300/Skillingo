package ru.hadj.skillingo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.domain.model.PomodoroTimer

interface PomodoroRepository {
    fun getPomodoroTimer(): Flow<PomodoroTimer>

    suspend fun updatePomodoroTimer(timer: PomodoroTimer)

    suspend fun resetPomodoroTimer()

    suspend fun toggleTimer()

    suspend fun skipPhase()

    suspend fun updateWorkDuration(duration: Long)

    suspend fun updateBreakDuration(duration: Long)

    suspend fun updateDailyGoal(goal: Int)
} 