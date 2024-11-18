package com.hadj.skillingo.screens.onboarding.section

import TaskGroupList
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hadj.uikit.mokoResource.Res
import dev.icerock.moko.resources.compose.stringResource
import ru.hadj.skillingo.domain.model.Task
import ru.hadj.skillingo.domain.model.TaskGroup
import ru.hadj.skillingo.uikit.component.card.SCard

@Composable
fun TaskGroupSections(modifier: Modifier = Modifier) {

    val completedTasks = remember { mutableStateListOf<Long>() }

    val taskGroups = listOf(
        TaskGroup(1, "HomeWork", 1) to listOf(
            Task(1, "Math", "Complete math exercises"),
            Task(2, "Science", "Read science chapter"),
            Task(3, "History", "Write history essay")
        ),
        TaskGroup(2, "DailyTask", 2) to listOf(
            Task(4, "Exercise", "Morning workout"),
            Task(5, "Meditation", "Evening meditation"),
            Task(6, "Reading", "Read a book")
        ),
        TaskGroup(3, "ProjectTask", 3) to listOf(
            Task(7, "Design", "Create design mockups"),
            Task(8, "Development", "Implement new feature"),
            Task(9, "Testing", "Test the application")
        )
    )

    SCard(
        modifier = modifier
    ) {
        Column(
            modifier = modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = stringResource(Res.strings.task_group_title),
                style = MaterialTheme.typography.displayLarge,
            )
            Text(
                text = stringResource(Res.strings.task_group_description),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(taskGroups, key = { it.first.id }) { (group, tasks) ->
                    val remainingTasks = tasks.filterNot { completedTasks.contains(it.id) }
                    if (remainingTasks.isNotEmpty()) {
                        TaskGroupList(
                            group = group,
                            tasks = remainingTasks,
                            onTaskCompleted = { taskId ->
                                completedTasks.add(taskId)
                            }
                        )
                    }
                }
            }
            Text(
                text = stringResource(Res.strings.task_completion_hint),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
