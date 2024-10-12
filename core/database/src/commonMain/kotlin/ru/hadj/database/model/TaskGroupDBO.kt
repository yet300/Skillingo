package ru.hadj.skillingo.data.mapper

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "task_group", foreignKeys = [
        ForeignKey(
            entity = TaskDBO::class,
            parentColumns = ["id"],
            childColumns = ["taskId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TaskGroupDBO(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val name: String,
    val taskId: String
)
