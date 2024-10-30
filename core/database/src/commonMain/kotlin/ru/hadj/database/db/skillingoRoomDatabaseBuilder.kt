package ru.hadj.database.db

import androidx.room.RoomDatabase
import ru.hadj.skillingo.common.PlatformContext

expect fun skillingoRoomDatabaseBuilder(context: PlatformContext): RoomDatabase.Builder<SkillingpRoomDatabase>
