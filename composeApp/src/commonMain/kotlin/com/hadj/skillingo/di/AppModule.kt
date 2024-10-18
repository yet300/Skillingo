package com.hadj.skillingo.di

import org.koin.core.annotation.Module
import ru.hadj.database.di.DataBaseModule
import ru.hadj.skillingo.data.di.DataModule

@Module(includes = [DataBaseModule::class, DataBaseModule::class, DataModule::class])
class AppModule