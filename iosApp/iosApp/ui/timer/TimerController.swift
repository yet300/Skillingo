//
//  TimerController.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/20/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Combine
import SwiftUICore

class TimerController: ObservableObject {
    @Published private(set) var timeLeft: Int
    @Published private(set) var isRunning: Bool
    @Published private(set) var isWorkPhase: Bool

    private let workDuration: Int
    private let breakDuration: Int
    private var timer: Timer?

    init(workDuration: Int, breakDuration: Int) {
        self.workDuration = workDuration
        self.breakDuration = breakDuration
        self.timeLeft = workDuration * 60
        self.isRunning = false
        self.isWorkPhase = true
    }

    func startTimer() {
        if isRunning { return }
        timer?.invalidate()
        timer = Timer.scheduledTimer(withTimeInterval: 1, repeats: true) { _ in
            if self.timeLeft > 0 {
                self.timeLeft -= 1
            } else {
                self.switchPhase()
            }
        }
        isRunning = true
    }

    func pauseTimer() {
        timer?.invalidate()
        isRunning = false
    }

    func resetTimer() {
        timer?.invalidate()
        timeLeft = isWorkPhase ? workDuration * 60 : breakDuration * 60
        isRunning = false
    }

    func switchPhase() {
        timer?.invalidate()
        isWorkPhase.toggle()
        timeLeft = isWorkPhase ? workDuration * 60 : breakDuration * 60
        isRunning = false
    }
}
