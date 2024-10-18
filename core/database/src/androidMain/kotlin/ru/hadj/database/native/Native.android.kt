package ru.hadj.database.native

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Factory
import ru.hadj.database.AppDatabase

@Factory
actual class Native(
    private val context: Context
) {
    actual fun provideDataBase(): RoomDatabase.Builder<AppDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath("skillingo.db")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}