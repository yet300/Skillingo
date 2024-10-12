package ru.hadj.skillingo.data.mapper

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("task")
data class TaskDBO(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val name: String,
    val description: String,
    val isComplete: Boolean = false
)