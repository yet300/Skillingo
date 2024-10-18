package ru.hadj.database.native

import org.koin.core.annotation.Single
import ru.hadj.database.AppDatabase

@Single
actual class Native {
    actual fun provideDataBase(): AppDatabase {
        TODO("Not yet implemented")
    }

}