package ru.hadj.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.data.mapper.TaskGroupDBO

@Dao
interface TaskGroupDao {
    @Query("SELECT * FROM task_group")
    fun getGroupTasks(): Flow<List<TaskGroupDBO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroupTask(taskGroup: TaskGroupDBO)

    @Query("UPDATE task_group SET name = :name WHERE id = :id")
    suspend fun updateGroupTask(id: String, name: String)


    @Query("DELETE FROM task_group WHERE id = :id")
    suspend fun deleteGroupTaskById(id: String)

}