package ru.hadj.database.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import ru.hadj.database.dao.BoostDao
import ru.hadj.database.dao.TaskDao
import ru.hadj.database.dao.TaskGroupDao
import ru.hadj.database.utils.Converters
import ru.hadj.skillingo.data.mapper.BoostModeDBO
import ru.hadj.skillingo.data.mapper.TaskDBO
import ru.hadj.skillingo.data.mapper.TaskGroupDBO

@Database(
    entities = [TaskDBO::class, TaskGroupDBO::class, BoostModeDBO::class],
    version = 1
)
@TypeConverters(Converters::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun taskGroupDao(): TaskGroupDao

    abstract fun boostDao(): BoostDao
}

internal const val dbFileName = "skillingo_db"

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}