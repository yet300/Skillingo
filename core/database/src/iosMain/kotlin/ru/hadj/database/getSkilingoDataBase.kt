package ru.hadj.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

//fun getSkillingoDataBase(): AppDatabase {
//    val dbFile = NSHomeDirectory() + "/skillingo.db"
//    return Room.databaseBuilder<AppDatabase>(
//        name = dbFile,
//        factory = { AppDatabase::class.instantiateImpl() }
//    )
//        .setDriver(BundledSQLiteDriver())
//        .build()
//}