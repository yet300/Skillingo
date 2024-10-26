package ru.hadj.database.db

import androidx.room.RoomDatabase

actual class DataBasePlatform actual constructor() {
    actual fun getDataBaseBuilder(): RoomDatabase.Builder<SkillingpRoomDatabase> {
        TODO("Not yet implemented")
    }
}