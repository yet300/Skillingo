package ru.hadj.skillingo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.domain.model.TaskGroup

interface TaskGroupRepository {

    fun getGroupTask(): Flow<List<TaskGroup>>

    suspend fun insertGroupTask(taskGroup: TaskGroup)

    suspend fun updateGroupTask(id: String, name: String)

    suspend fun deleteGroupByIdTask(id: String)

}