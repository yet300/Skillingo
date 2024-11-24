package ru.hadj.skillingo.data.mapper

import ru.hadj.database.model.PomodoroTimerDBO
import ru.hadj.skillingo.domain.model.PomodoroTimer

fun PomodoroTimerDBO.toPomodoroTimer() = PomodoroTimer(
    id = id,
    isWorkPhase = isWorkPhase,
    isRunning = isRunning,
    workDuration = workDuration,
    breakDuration = breakDuration,
    endTime = endTime,
    currentPhaseStartTime = currentPhaseStartTime,
    completedPomodoros = completedPomodoros,
    dailyGoal = dailyGoal
)

fun PomodoroTimer.toDBO() = PomodoroTimerDBO(
    id = id,
    isWorkPhase = isWorkPhase,
    isRunning = isRunning,
    workDuration = workDuration,
    breakDuration = breakDuration,
    endTime = endTime,
    currentPhaseStartTime = currentPhaseStartTime,
    completedPomodoros = completedPomodoros,
    dailyGoal = dailyGoal
) 