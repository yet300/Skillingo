package com.hadj.skillingo

import androidx.room.RoomDatabase
import ru.hadj.database.db.SkillingpRoomDatabase

expect fun skillingoRoomDatabaseBuilder(context: PlatformContext): RoomDatabase.Builder<SkillingpRoomDatabase>