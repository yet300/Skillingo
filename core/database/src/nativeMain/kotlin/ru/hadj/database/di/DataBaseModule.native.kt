package ru.hadj.database.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSHomeDirectory
import ru.hadj.database.db.SkillingpRoomDatabase

actual val dataBasePlatformModule: Module = module {
    factory<RoomDatabase.Builder<SkillingpRoomDatabase>>{
        Room.databaseBuilder<SkillingpRoomDatabase>(
            name = "${NSHomeDirectory()}/skillingp.db",
            factory = { instantiateSkillingoRoomDatabase() }
        ).setDriver(BundledSQLiteDriver())
    }
}