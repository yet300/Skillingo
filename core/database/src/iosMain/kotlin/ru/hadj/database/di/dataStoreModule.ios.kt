package ru.hadj.database.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.hadj.database.db.createDataStore

actual val dataStoreModule: Module = module {
    single { createDataStore() }
}