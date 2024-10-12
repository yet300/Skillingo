package ru.hadj.database.utils

import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

internal class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long): Instant {
        return Instant.fromEpochMilliseconds(value)
    }

    @TypeConverter
    fun dateToTimestamp(instant: Instant): Long {
        return instant.toEpochMilliseconds()
    }

    @TypeConverter
    fun convert(value: Duration?): Long? = value?.inWholeMilliseconds

    @TypeConverter
    fun convert(value: Long?): Duration? = value?.milliseconds
}