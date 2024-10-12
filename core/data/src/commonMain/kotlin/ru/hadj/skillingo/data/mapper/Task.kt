package ru.hadj.skillingo.data.mapper

import ru.hadj.skillingo.domain.model.Task

fun TaskDBO.toTask() = Task(
    id, name, description, isComplete
)

fun Task.toDBO() = TaskDBO(
    id, name, description, isComplete
)