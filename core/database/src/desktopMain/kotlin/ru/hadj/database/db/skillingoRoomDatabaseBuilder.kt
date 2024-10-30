package ru.hadj.database.db

import androidx.room.Room
import androidx.room.RoomDatabase
import ru.hadj.skillingo.common.PlatformContext
import java.io.File


actual fun skillingoRoomDatabaseBuilder(context: PlatformContext): RoomDatabase.Builder<SkillingpRoomDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
    return Room.databaseBuilder<SkillingpRoomDatabase>(
        name = dbFile.absolutePath,
    )
}