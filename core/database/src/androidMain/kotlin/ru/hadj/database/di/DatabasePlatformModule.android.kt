package ru.hadj.database.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("ru.hadj.database.db")
actual class DatabasePlatformModule