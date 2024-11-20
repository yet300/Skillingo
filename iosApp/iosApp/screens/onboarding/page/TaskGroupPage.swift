import SwiftUI
import Shared

//
//  TaskGroupPage.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/18/24.
//  Copyright © 2024 orgName. All rights reserved.
//

struct TaskGroupPage: View {
    let taskGroups: [(TaskGroup, [Task])] = [
        (TaskGroup(id: 1, name: "HomeWork", taskId: 1), [
            Task(id: 1, name: "Math", description: "Complete math exercises", isComplete: false),
            Task(id: 2, name: "Science", description: "Read science chapter", isComplete: false),
            Task(id: 3, name: "History", description: "Write history essay", isComplete: false)
        ]),
        (TaskGroup(id: 2, name: "DailyTask", taskId: 2), [
            Task(id: 4, name: "Exercise", description: "Morning workout", isComplete: false),
            Task(id: 5, name: "Meditation", description: "Evening meditation", isComplete: false),
            Task(id: 6, name: "Reading", description: "Read a book", isComplete: false)
        ]),
        (TaskGroup(id: 3, name: "ProjectTask", taskId: 3), [
            Task(id: 7, name: "Design", description: "Create design mockups", isComplete: false),
            Task(id: 8, name: "Development", description: "Implement new feature", isComplete: false),
            Task(id: 9, name: "Testing", description: "Test the application", isComplete: false)
        ])
    ]

    var body: some View {
        ScrollView {
            CardView {
                VStack(alignment: .leading, spacing: 8) {
                    Text(Res.strings().task_group_title .desc().localized())
                        .font(.largeTitle)
                    
                    Text(Strings().get(id: Res.strings().task_group_description, args: []))
                        .font(.body)
                    
                    TaskGroupListView(taskGroups: taskGroups)

                    Text(Res.strings().task_completion_hint.desc().localized())
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                }
            }
        }
    }
}
