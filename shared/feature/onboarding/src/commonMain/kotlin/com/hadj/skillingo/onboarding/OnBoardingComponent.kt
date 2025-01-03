package com.hadj.skillingo.onboarding

import com.arkivanov.decompose.value.Value
import ru.hadj.skillingo.domain.model.ThemeMode

interface OnBoardingComponent {
    val model: Value<Model>
    suspend fun changeThemeMode(themeMode: ThemeMode)

    fun onClick()

    fun nextPage()

    fun startTimer()
    fun pauseTimer()
    fun resetTimer()
    fun switchPhase()

    data class Model(
        val currentThemeMode: ThemeMode = ThemeMode.SYSTEM,
        val currentPage: Int = 0,
        val totalPages: Int = 6,

        val timeLeft: Long = 0L,
        val isRunning: Boolean = false,
        val isWorkPhase: Boolean = true
    )
}