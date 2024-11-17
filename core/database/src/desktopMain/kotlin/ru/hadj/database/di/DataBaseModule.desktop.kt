package ru.hadj.database.di

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.hadj.database.db.PomodoroRoomDatabase
import ru.hadj.database.db.SkillingpRoomDatabase
import ru.hadj.database.db.dbFileName
import ru.hadj.database.db.pomodoroDbFileName
import java.io.File

actual val dataBasePlatformModule: Module = module {
    single<File> {
        File(System.getProperty("java.io.tmpdir"), dbFileName)
    }
    single<File> {
        File(System.getProperty("java.io.tmpdir"), pomodoroDbFileName)
    }

    factory<RoomDatabase.Builder<SkillingpRoomDatabase>> {
        Room.databaseBuilder<SkillingpRoomDatabase>(
            name = get<File>().absolutePath,
        )
    }

    factory<RoomDatabase.Builder<PomodoroRoomDatabase>> {
        Room.databaseBuilder<PomodoroRoomDatabase>(
            name = get<File>().absolutePath,
        )
    }
}