package ru.hadj.skillingo.data.implementation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.hadj.database.SkillingoDatabase
import ru.hadj.skillingo.data.mapper.toDBO
import ru.hadj.skillingo.data.mapper.toTaskGroup
import ru.hadj.skillingo.domain.model.TaskGroup
import ru.hadj.skillingo.domain.repository.TaskGroupRepository

class TaskGroupRepositoryImpl(
    private val database: SkillingoDatabase,
) : TaskGroupRepository {

    override fun getGroupTask(): Flow<List<TaskGroup>> = flow {
        database.taskGroupDao().getGroupTasks().collect { taskGroupDBOs ->
            taskGroupDBOs.map { it.toTaskGroup() }
        }
    }

    override suspend fun insertGroupTask(taskGroup: TaskGroup) {
        database.taskGroupDao().insertGroupTask(taskGroup.toDBO())
    }

    override suspend fun updateGroupTask(id: String, name: String) {
        database.taskGroupDao().updateGroupTask(id = id, name = name)
    }

    override suspend fun deleteGroupByIdTask(id: String) {
        database.taskGroupDao().deleteGroupTaskById(id = id)
    }
}