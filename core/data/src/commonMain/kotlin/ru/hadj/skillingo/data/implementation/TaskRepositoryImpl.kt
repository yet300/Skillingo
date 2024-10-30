package ru.hadj.skillingo.data.implementation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.tatarka.inject.annotations.Inject
//import ru.hadj.database.db.SkillingoDatabase
import ru.hadj.database.db.SkillingpRoomDatabase
import ru.hadj.skillingo.data.mapper.toDBO
import ru.hadj.skillingo.data.mapper.toTask
import ru.hadj.skillingo.domain.model.Task
import ru.hadj.skillingo.domain.repository.TaskRepository

@Inject
class TaskRepositoryImpl(
    private val database: SkillingpRoomDatabase,
) : TaskRepository {

    override fun getTasks(): Flow<List<Task>> = flow {
        database.taskDao().getTasks().collect { taskDBOs ->
            emit(taskDBOs.map { it.toTask() })
        }
    }

    override suspend fun insertTask(task: Task) {
        return database.taskDao().insertTask(task.toDBO())
    }

    override suspend fun updateTask(task: Task) {
        database.taskDao().updateTask(task.toDBO())
    }

    override suspend fun deleteTask(id: String) {
        database.taskDao().deleteTaskById(id = id)
    }

    override suspend fun deleteAllTasks() {
        return database.taskDao().deleteAllTasks()
    }
}