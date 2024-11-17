package ru.hadj.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant
import kotlin.time.Duration

@Entity(tableName = "pomodoro_timer")
data class PomodoroTimerDBO(
    @PrimaryKey
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