package ru.hadj.database.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single
import ru.hadj.database.dao.BoostDao
import ru.hadj.database.dao.TaskDao
import ru.hadj.database.dao.TaskGroupDao
import ru.hadj.database.utils.Converters
import ru.hadj.skillingo.data.mapper.BoostModeDBO
import ru.hadj.skillingo.data.mapper.TaskDBO
import ru.hadj.skillingo.data.mapper.TaskGroupDBO

class SkillingoDatabase internal constructor(private val database: SkillingpRoomDatabase) {
    val taskDao: TaskDao
        get() = database.taskDao()

    val taskGroupDao: TaskGroupDao
        get() = database.taskGroupDao()

    val boostDao: BoostDao
        get() = database.boostDao()
}

@Database(
    entities = [TaskDBO::class, TaskGroupDBO::class, BoostModeDBO::class],
    version = 1
)
@TypeConverters(Converters::class)
@ConstructedBy(SkillingoRoomDatabaseConstructor::class)
abstract class SkillingpRoomDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    abstract fun taskGroupDao(): TaskGroupDao

    abstract fun boostDao(): BoostDao
}

internal const val dbFileName = "skillingo_db"

@Single
fun SkillingoDatabase(
    @Provided databaseBuilder: RoomDatabase.Builder<SkillingpRoomDatabase>,
): SkillingoDatabase {
    return SkillingoDatabase(
        databaseBuilder
            .setQueryCoroutineContext(Dispatchers.IO)
            .fallbackToDestructiveMigration(dropAllTables = false)
            .build()
    )
}


// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object SkillingoRoomDatabaseConstructor : RoomDatabaseConstructor<SkillingpRoomDatabase> {
    override fun initialize(): SkillingpRoomDatabase
}