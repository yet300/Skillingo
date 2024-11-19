import Shared
import SwiftUI

//
//  PomodoroPage.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/18/24.
//  Copyright © 2024 orgName. All rights reserved.
//


struct PomodoroPage: View {
    var body: some View {
        CardView {
            VStack {
                Text("Pomodoro Timer")
                    .font(.largeTitle)
                Text("Learn how to use the Pomodoro Timer to boost your productivity.")
                    .font(.body)
            }
        }
    }
}
