import SwiftUI
import Shared
//
//  TaskView.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/20/24.
//  Copyright © 2024 orgName. All rights reserved.
//

struct TaskView: View {
    let task: Task
    @Binding var completedTasks: Set<Int64>

    var body: some View {
        Text(task.name)
            .padding()
            .frame(maxWidth: .infinity)
            .background(
                RoundedRectangle(cornerRadius: 10)
                    .fill(Color(.systemBackground))
                    .shadow(radius: 2)
            )
            .onTapGesture {
                withAnimation {
                    completedTasks.insert(task.id)
                    let generator = UIImpactFeedbackGenerator(style: .medium)
                    generator.impactOccurred()
                }
            }
    }
}
