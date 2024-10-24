package ru.hadj.database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import ru.hadj.database.db.AppDatabase
import ru.hadj.database.db.DataBaseFactory

@Module(includes = [DataBaseModulePlatform::class])
@ComponentScan
class DataBaseModule{

    @Single
    fun getRoomDatabase(
        builder: DataBaseFactory
    ): AppDatabase {
        return builder
            .createDatabase()
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}