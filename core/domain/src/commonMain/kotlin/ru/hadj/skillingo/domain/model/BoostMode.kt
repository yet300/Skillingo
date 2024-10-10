package ru.hadj.skillingo.domain.model

import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration


data class BoostMode(
    val id: String,
    val isActive: Boolean = false,
    val startTime: LocalDateTime? = null,
    val duration: Duration = Duration.ZERO
)