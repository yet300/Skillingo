package ru.hadj.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.koin.core.annotation.Single
import ru.hadj.database.dao.BoostDao
import ru.hadj.database.dao.TaskDao
import ru.hadj.database.dao.TaskGroupDao
import ru.hadj.skillingo.data.mapper.BoostModeDBO
import ru.hadj.skillingo.data.mapper.TaskDBO
import ru.hadj.skillingo.data.mapper.TaskGroupDBO

@Database(
    entities = [TaskDBO::class, TaskGroupDBO::class, BoostModeDBO::class],
    version = 1
)
@Single
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun taskGroupDao(): TaskGroupDao

    abstract fun boostDao(): BoostDao

}