import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.hadj.skillingo.domain.model.Task
import ru.hadj.skillingo.domain.model.TaskGroup
import ru.hadj.skillingo.uikit.component.task.TaskItem

@Composable
fun TaskGroupList(
    modifier: Modifier = Modifier,
    group: TaskGroup,
    tasks: List<Task>,
    onTaskCompleted: (Long) -> Unit
) {
    Column(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colorScheme.surface)
            .width(300.dp)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = group.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
        )
        TaskList(
            tasks = tasks,
            onTaskCompleted = onTaskCompleted
        )
    }
}


@Composable
fun TaskList(
    modifier: Modifier = Modifier,
    tasks: List<Task>,
    onTaskCompleted: (Long) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks, key = { it.id }) { task ->
                TaskItem(
                    task = task,
                    onTaskCompleted = { onTaskCompleted(task.id) }
                )
            }
        }
    }
}