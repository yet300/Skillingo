package ru.hadj.skillingo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.domain.model.PomodoroTimer

interface PomodoroRepository {

    fun getTimers(): Flow<List<PomodoroTimer>>

    fun getPomodoroTimer(id: Long): Flow<PomodoroTimer?>

    suspend fun insertPomodoroTimer(timer: PomodoroTimer)

    suspend fun updatePomodoroTimer(timer: PomodoroTimer)

    suspend fun updateDailyGoal(id: Long, goal: Int)

    suspend fun deleteTimer(timer: PomodoroTimer)
} 