package ru.hadj.database.db

import androidx.room.Room
import androidx.room.RoomDatabase
import ru.hadj.skillingo.common.PlatformContext


actual fun skillingoRoomDatabaseBuilder(context: PlatformContext): RoomDatabase.Builder<SkillingpRoomDatabase> {
    return Room.databaseBuilder(
        context = context,
        klass = SkillingpRoomDatabase::class.java,
        name = "skillingo"
    )
}