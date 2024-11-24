package ru.hadj.skillingo.data.implementation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import ru.hadj.database.db.PomodoroDatabase
import ru.hadj.skillingo.data.mapper.toDBO
import ru.hadj.skillingo.data.mapper.toPomodoroTimer
import ru.hadj.skillingo.domain.model.PomodoroTimer
import ru.hadj.skillingo.domain.repository.PomodoroRepository

class PomodoroRepositoryImpl(
    private val database: PomodoroDatabase,
) : PomodoroRepository {

    override fun getPomodoroTimer(id: Long): Flow<PomodoroTimer> = flow {
        database.pomodoroDao.getPomodoroTimer().collect { timer ->
            if (timer != null) {
                emit(timer.toPomodoroTimer())
            }
        }
    }

    override fun getTimers(): Flow<List<PomodoroTimer>> = flow {
        val result = database.pomodoroDao.getPomodoroTimers()

        result.collect { timers ->
            emit(timers.map { it.toPomodoroTimer() })
        }
    }

    override suspend fun insertPomodoroTimer(timer: PomodoroTimer) {
        database.pomodoroDao.insertPomodoroTimer(timer.toDBO())
    }

    override suspend fun updatePomodoroTimer(timer: PomodoroTimer) {
        database.pomodoroDao.updatePomodoroTimer(timer.toDBO())
    }

    override suspend fun updateDailyGoal(id: Long, goal: Int) {
        val timer = getPomodoroTimer(id).first()
        val updatedTimer = timer.copy(dailyGoal = goal)
        return updatePomodoroTimer(updatedTimer)
    }

    override suspend fun deleteTimer(timer: PomodoroTimer) {
        database.pomodoroDao.deletePomodoroTimer(timer.id)
    }
}