package com.hadj.skillingo.onboarding

import com.arkivanov.decompose.value.Value
import ru.hadj.skillingo.domain.model.ThemeMode

interface OnBoardingComponent {
    val model: Value<Model>
    suspend fun changeThemeMode(themeMode: ThemeMode)

    fun onClick()

    data class Model(
        val currentThemeMode: ThemeMode = ThemeMode.SYSTEM
    )
}