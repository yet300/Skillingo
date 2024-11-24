package ru.hadj.skillingo.githubapi.model

import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.Serializable
import ru.hadj.skillingo.githubapi.utils.DurationSerializer
import kotlin.time.Duration

@Serializable
data class PomodoroTimerDTO(
    val id: Long = 0,
    val isWorkPhase: Boolean = true,
    val isRunning: Boolean = false,
    @Serializable(with = DurationSerializer::class) val workDuration: Duration,
    @Serializable(with = DurationSerializer::class) val breakDuration: Duration,
    @Serializable(with = InstantIso8601Serializer::class) val endTime: Instant? = null,
    @Serializable(with = InstantIso8601Serializer::class) val currentPhaseStartTime: Instant? = null,
    val completedPomodoros: Int = 0,
    val dailyGoal: Int = 8
)