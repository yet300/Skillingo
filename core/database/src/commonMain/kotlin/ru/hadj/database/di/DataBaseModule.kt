package ru.hadj.database.di

import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import ru.hadj.database.db.SkillingoDatabase
import ru.hadj.database.db.SkillingpRoomDatabase

val databaseModule = module {
    single<SkillingoDatabase> {
        SkillingoDatabase(
            get<RoomDatabase.Builder<SkillingpRoomDatabase>>()
                .setQueryCoroutineContext(Dispatchers.IO)
                .fallbackToDestructiveMigration(dropAllTables = false)
                .build()
        )
    }
} + dataBasePlatformModule