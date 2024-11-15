package ru.hadj.skillingo.data.mapper

import ru.hadj.database.model.ThemeModeDBO
import ru.hadj.skillingo.domain.model.ThemeMode

fun ThemeMode.toThemeModeDBO(): ThemeModeDBO = when (this) {
    ThemeMode.LIGHT -> ThemeModeDBO.LIGHT
    ThemeMode.DARK -> ThemeModeDBO.DARK
    ThemeMode.SYSTEM -> ThemeModeDBO.SYSTEM
}

fun ThemeModeDBO.toThemeMode(): ThemeMode = when (this) {
    ThemeModeDBO.LIGHT -> ThemeMode.LIGHT
    ThemeModeDBO.DARK -> ThemeMode.DARK
    ThemeModeDBO.SYSTEM -> ThemeMode.SYSTEM
}