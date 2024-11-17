package ru.hadj.database.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import ru.hadj.database.dao.PomodoroDao
import ru.hadj.database.model.PomodoroTimerDBO
import ru.hadj.database.utils.Converters

class PomodoroDatabase internal constructor(private val database: PomodoroRoomDatabase) {
    val pomodoroDao: PomodoroDao
        get() = database.pomodoroDao()
}

@Database(
    entities = [PomodoroTimerDBO::class],
    version = 1
)
@TypeConverters(Converters::class)
@ConstructedBy(PomodoroRoomDatabaseConstructor::class)
abstract class PomodoroRoomDatabase : RoomDatabase() {
    abstract fun pomodoroDao(): PomodoroDao
}

internal const val pomodoroDbFileName = "pomodoro_db"

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object PomodoroRoomDatabaseConstructor : RoomDatabaseConstructor<PomodoroRoomDatabase> {
    override fun initialize(): PomodoroRoomDatabase
} 