package ru.hadj.database.db

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Single
import java.io.File

@Single

actual class DataBaseFactory {
    actual fun createDatabase(): RoomDatabase.Builder<AppDatabase> {
        val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath,
        )
    }
}