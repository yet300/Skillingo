package ru.hadj.database.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory
import ru.hadj.skillingo.common.PlatformContext

actual fun skillingoRoomDatabaseBuilder(context: PlatformContext): RoomDatabase.Builder<SkillingpRoomDatabase> {
    return Room.databaseBuilder<SkillingpRoomDatabase>(
        name = "${NSHomeDirectory()}/skillingo.db",
        factory =  { instantiateSkillingoRoomDataBase() }
    ).setDriver(BundledSQLiteDriver())
}