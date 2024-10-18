package ru.hadj.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.Single
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
@ConstructedBy(AppDatabaseConstructorConstructor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun taskGroupDao(): TaskGroupDao

    abstract fun boostDao(): BoostDao

}

@Single
fun AppDatabase(
    builder: RoomDatabase.Builder<AppDatabase>,
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
): AppDatabase {
    return builder
        .setQueryCoroutineContext(dispatcher)
        .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
        .setDriver(BundledSQLiteDriver())
        .build()
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructorConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}