package ru.hadj.skillingo.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.hadj.skillingo.domain.model.Task

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>

    suspend fun insertTask(task: Task)

    suspend fun updateTask(): Task

    suspend fun deleteTask(): Task
}