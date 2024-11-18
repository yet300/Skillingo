package com.hadj.skillingo.onboarding

import com.arkivanov.decompose.value.Value
import ru.hadj.skillingo.domain.model.ThemeMode

interface OnBoardingComponent {
    val model: Value<Model>
    suspend fun changeThemeMode(themeMode: ThemeMode)

    fun onClick()

    fun nextPage()
    fun isLastPage(): Boolean

    data class Model(
        val currentThemeMode: ThemeMode = ThemeMode.SYSTEM,
        val currentPage: Int = 0,
        val totalPages: Int = 6
    )
}