import SwiftUI
import Shared

struct TaskGroupListView: View {
    let taskGroups: [(TaskGroup, [Task])]
    @State private var completedTasks: Set<Int64> = []

    var body: some View {
        ScrollView(.horizontal, showsIndicators: false) {
            LazyHStack(spacing: 16) {
                ForEach(taskGroups, id: \.0.id) { group, tasks in
                    VStack(alignment: .leading, spacing: 8) {
                        Text(group.name)
                            .font(.headline)
                            .padding(.bottom, 4)

                        ForEach(tasks, id: \.id) { task in
                            if !completedTasks.contains(task.id) {
                                TaskView(task: task, completedTasks: $completedTasks)
                            }
                        }
                    }
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(
                        RoundedRectangle(cornerRadius: 10)
                            .fill(Color(.systemBackground))
                            .shadow(radius: 2)
                    )
                }
            }
            .padding()
        }
    }
}
