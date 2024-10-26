package ru.hadj.database.di


import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [DatabasePlatformModule::class])
@ComponentScan
class DataBaseModule