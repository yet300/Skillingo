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
    @StateObject private var timerController = TimerController(workDuration: 25, breakDuration: 5)

    var body: some View {
        ScrollView {
            CardView {
                VStack(alignment: .leading, spacing: 8) {
                    Text(Res.strings().pomadoro_timer_title.desc().localized())
                        .font(.largeTitle)
                    
                    Text(Res.strings().pomadoro_timer_description.desc().localized())
                        .font(.body)
                    
                    VStack {
                        HStack {
                            Text(timerController.isWorkPhase ? "🍅" : "☕️")
                                .font(.largeTitle)
                            Text(timerController.isWorkPhase ? "Focus" : "Break")
                                .font(.body)
                        }
                        
                        Text(formatTime(timerController.timeLeft))
                            .font(.system(size: 48, weight: .bold, design: .monospaced))
                        
                        HStack {
                            Button(action: timerController.resetTimer) {
                                Image(systemName: "arrow.counterclockwise")
                                    .font(.headline)
                                    .padding()
                                    .background(Color.gray)
                                    .foregroundColor(.white)
                                    .cornerRadius(8)
                            }
                            
                            Button(action: {
                                if timerController.isRunning {
                                    timerController.pauseTimer()
                                } else {
                                    timerController.startTimer()
                                }
                            }) {
                                Image(systemName: timerController.isRunning ? "pause.fill" : "play.fill")
                                    .font(.headline)
                                    .padding()
                                    .background(timerController.isRunning ? Color.red : Color.green)
                                    .foregroundColor(.white)
                                    .cornerRadius(8)
                            }
                            
                            Button(action: timerController.switchPhase) {
                                Image(systemName: "forward.fill")
                                    .font(.headline)
                                    .padding()
                                    .background(Color.blue)
                                    .foregroundColor(.white)
                                    .cornerRadius(8)
                            }
                        }
                    }
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(timerController.isWorkPhase ? Color.green.opacity(0.2) : Color.blue.opacity(0.2))
                    .cornerRadius(10)
                }
                .padding()
            }
        }
    }

    private func formatTime(_ seconds: Int) -> String {
        let minutes = seconds / 60
        let seconds = seconds % 60
        return String(format: "%02d:%02d", minutes, seconds)
    }
} 
