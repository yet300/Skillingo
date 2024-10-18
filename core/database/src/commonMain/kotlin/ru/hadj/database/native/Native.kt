package ru.hadj.database.native


import androidx.room.RoomDatabase
import ru.hadj.database.AppDatabase

expect class Native {
    fun provideDataBase(): RoomDatabase.Builder<AppDatabase>
}