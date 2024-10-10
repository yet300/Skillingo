package ru.hadj.skillingo.domain.model

data class Task(
    val id: String,
    val name: String,
    val description: String,
    val isComplete: Boolean = false
)

