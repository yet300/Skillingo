package ru.hadj.database.native

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Factory
import ru.hadj.database.AppDatabase

@Factory
actual class Native {
    actual fun provideDataBase(): RoomDatabase.Builder<AppDatabase> {
        val dbFilePath = documentDirectory() + "/skillingo.db"
        return Room.databaseBuilder<AppDatabase>(
            name = dbFilePath,
        )
    }

    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory?.path)
    }
}