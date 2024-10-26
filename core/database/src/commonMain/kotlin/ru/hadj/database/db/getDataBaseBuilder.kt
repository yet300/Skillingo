package ru.hadj.database.db

import androidx.room.RoomDatabase

expect class DataBasePlatform(){
    fun getDataBaseBuilder() : RoomDatabase.Builder<SkillingpRoomDatabase>
}

