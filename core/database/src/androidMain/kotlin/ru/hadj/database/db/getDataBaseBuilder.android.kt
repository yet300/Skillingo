package ru.hadj.database.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Factory


@Factory
actual class DataBasePlatform(private val context: Context) {
    actual fun getDataBaseBuilder(): RoomDatabase.Builder<SkillingpRoomDatabase> {
        return Room.databaseBuilder(
            context = context,
            klass = SkillingpRoomDatabase::class.java,
            name = "skiliingo"
        )
    }
}