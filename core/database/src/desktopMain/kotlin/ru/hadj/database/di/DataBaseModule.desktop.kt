package ru.hadj.database.di

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.hadj.database.db.SkillingpRoomDatabase
import ru.hadj.database.db.dbFileName
import java.io.File

actual val dataBasePlatformModule: Module = module {
    single<File> {
        File(System.getProperty("java.io.tmpdir"), dbFileName)
    }
    factory<RoomDatabase.Builder<SkillingpRoomDatabase>> {
        Room.databaseBuilder<SkillingpRoomDatabase>(
            name = get<File>().absolutePath,
        )
    }
}