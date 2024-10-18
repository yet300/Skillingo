package ru.hadj.database.native

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Factory
import ru.hadj.database.AppDatabase
import java.io.File

@Factory
actual class Native {
    actual fun provideDataBase(): RoomDatabase.Builder<AppDatabase> {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "skillingo.db")
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath,
        )
    }
}