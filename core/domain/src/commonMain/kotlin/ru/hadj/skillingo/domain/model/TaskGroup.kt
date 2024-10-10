package ru.hadj.skillingo.domain.model

data class TaskGroup(
    val id: String,
    val name: String,
    val task: Task
)