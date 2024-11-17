package ru.hadj.database.di

import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.hadj.database.db.PomodoroDatabase
import ru.hadj.database.db.PomodoroRoomDatabase
import ru.hadj.database.db.SkillingoDatabase
import ru.hadj.database.db.SkillingpRoomDatabase
import ru.hadj.database.store.OnBoardingDataStore
import ru.hadj.database.store.ThemeModeDataStore

val databaseModule = module {
    single<SkillingoDatabase> {
        SkillingoDatabase(
            get<RoomDatabase.Builder<SkillingpRoomDatabase>>()
                .setQueryCoroutineContext(Dispatchers.IO)
                .fallbackToDestructiveMigration(dropAllTables = false)
                .build()
        )
    }

    single<PomodoroDatabase> {
        PomodoroDatabase(
            get<RoomDatabase.Builder<PomodoroRoomDatabase>>()
                .setQueryCoroutineContext(Dispatchers.IO)
                .fallbackToDestructiveMigration(dropAllTables = false)
                .build()
        )
    }

    singleOf(::OnBoardingDataStore)
    singleOf(::ThemeModeDataStore)

} + dataBasePlatformModule + dataStoreModule