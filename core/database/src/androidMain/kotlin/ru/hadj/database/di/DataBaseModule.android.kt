package ru.hadj.database.di

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.hadj.database.db.PomodoroRoomDatabase
import ru.hadj.database.db.SkillingpRoomDatabase

actual val dataBasePlatformModule: Module = module {
    factory<RoomDatabase.Builder<SkillingpRoomDatabase>> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = SkillingpRoomDatabase::class.java,
            name = "skillingo"
        )
    }

    factory<RoomDatabase.Builder<PomodoroRoomDatabase>> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = PomodoroRoomDatabase::class.java,
            name = "pomodoro"
        )
    }
}