package ru.hadj.skillingo.data.mapper

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant
import kotlin.time.Duration

@Entity(tableName = "boost_mode")
data class BoostModeDBO(
    @PrimaryKey
    val id: Long,
    val isActive: Boolean = false,
    val startTime: Instant? = null,
    val duration: Duration = Duration.ZERO
)