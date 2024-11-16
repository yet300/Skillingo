package ru.hadj.skillingo.domain.model

import kotlinx.datetime.Instant
import kotlin.time.Duration

data class PomodoroTimer(
    val id: Long = 0,
    val isWorkPhase: Boolean = true,
    val isRunning: Boolean = false,
    val workDuration: Duration,
    val breakDuration: Duration,
    val endTime: Instant? = null,
    val currentPhaseStartTime: Instant? = null,
    val completedPomodoros: Int = 0,
    val dailyGoal: Int = 8
)