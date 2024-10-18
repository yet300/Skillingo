package ru.hadj.skillingo.domain.model

import kotlinx.datetime.Instant
import kotlin.time.Duration


data class BoostMode(
    val id: Long,
    val isActive: Boolean = false,
    val startTime: Instant? = null,
    val duration: Duration = Duration.ZERO
)