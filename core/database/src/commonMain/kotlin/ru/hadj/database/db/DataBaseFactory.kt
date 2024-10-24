package ru.hadj.database.db

import androidx.room.RoomDatabase

expect class DataBaseFactory {
    fun createDatabase(): RoomDatabase.Builder<AppDatabase>
}