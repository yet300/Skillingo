package ru.hadj.skillingo.uikit.component.timer

data class TimerState(
    val isWorkPhase: Boolean = true,
    val isRunning: Boolean = false,
    val timeLeft: Int = 25,
    val workDuration: Int = 25,
    val breakDuration: Int = 5
) 