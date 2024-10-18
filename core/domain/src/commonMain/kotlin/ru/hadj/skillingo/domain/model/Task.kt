package ru.hadj.skillingo.domain.model

data class Task(
    val id: Long,
    val name: String,
    val description: String,
    val isComplete: Boolean = false
)

