package ru.hadj.skillingo.data.mapper

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.datetime.Instant
import ru.hadj.database.utils.Converters
import kotlin.time.Duration

@Entity(tableName = "boost_mode")
@TypeConverters(Converters::class)
data class BoostModeDBO(
    @PrimaryKey
    val id: String,
    val isActive: Boolean = false,
    val startTime: Instant? = null,
    val duration: Duration = Duration.ZERO
)