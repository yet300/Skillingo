package ru.hadj.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.hadj.database.model.PomodoroTimerDBO

@Dao
interface PomodoroDao {
    @Query("SELECT * FROM pomodoro_timer")
    fun getPomodoroTimers(): Flow<List<PomodoroTimerDBO>>

    @Query("SELECT * FROM pomodoro_timer WHERE id = :id")
    fun getPomodoroTimer(id: Long = 0): Flow<PomodoroTimerDBO?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPomodoroTimer(timer: PomodoroTimerDBO)

    @Update
    suspend fun updatePomodoroTimer(timer: PomodoroTimerDBO)

    @Query("DELETE FROM pomodoro_timer WHERE id = :id")
    suspend fun deletePomodoroTimer(id: Long = 0)
}