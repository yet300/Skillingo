package ru.hadj.database.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.koin.core.annotation.Factory
import platform.Foundation.NSHomeDirectory

@Factory
actual class DataBasePlatform {
    actual fun getDataBaseBuilder(): RoomDatabase.Builder<SkillingpRoomDatabase> {
        return Room.databaseBuilder<SkillingpRoomDatabase>(
            name = "${NSHomeDirectory()}/skillingp.db",
            factory = { instantiateSkillingoRoomDatabase() }
        ).setDriver(BundledSQLiteDriver())
    }
}