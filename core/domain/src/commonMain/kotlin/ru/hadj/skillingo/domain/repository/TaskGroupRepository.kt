package ru.hadj.skillingo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.domain.model.TaskGroup

interface TaskGroupRepository {

    fun getGroupTask(): Flow<List<TaskGroup>>

    suspend fun insertGroupTask(taskGroup: TaskGroup)

    suspend fun updateGroupTask(name: String): TaskGroup

    suspend fun deleteGroupByIdTask(id: String): TaskGroup

    suspend fun deleteGroupTask(): TaskGroup

}