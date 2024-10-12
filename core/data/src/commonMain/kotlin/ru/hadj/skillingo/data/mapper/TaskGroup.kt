package ru.hadj.skillingo.data.mapper

import ru.hadj.skillingo.domain.model.TaskGroup

fun TaskGroupDBO.toTaskGroup() = TaskGroup(
    id, name, taskId
)

fun TaskGroup.toDBO() = TaskGroupDBO(
    id, name, taskId
)