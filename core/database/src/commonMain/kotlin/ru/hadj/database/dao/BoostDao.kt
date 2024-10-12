package ru.hadj.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.data.mapper.BoostModeDBO

@Dao
interface BoostDao {
    @Query("SELECT * FROM boost_mode WHERE id = :id")
    fun getBoostMode(id: String): Flow<BoostModeDBO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBoostMode(boostMode: BoostModeDBO)

    @Update
    suspend fun updateBoostMode(boostMode: BoostModeDBO)

    @Query("DELETE FROM boost_mode WHERE id = :id")
    suspend fun deleteBoostMode(id: String)

}