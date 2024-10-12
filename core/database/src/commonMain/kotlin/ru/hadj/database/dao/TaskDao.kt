package ru.hadj.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.data.mapper.TaskDBO

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<TaskDBO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskDBO)

    @Update
    suspend fun updateTask(task: TaskDBO)

    @Query("DELETE FROM task WHERE id = :id")
    suspend fun deleteTaskById(id: String)

    @Query("DELETE FROM task")
    suspend fun deleteAllTasks()
}