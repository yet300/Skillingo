//  OnBoardingView.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct OnBoardingView: View {
    private let onboarding: OnBoardingComponent
    private let totalPages = 6

    @State private var currentPage = 0

    init(onboarding: OnBoardingComponent) {
        self.onboarding = onboarding
    }
    
    var body: some View {
        VStack {
            TabView(selection: $currentPage) {
                WelcomePage()
                    .tag(0)
                ThemePage(component: onboarding)
                    .tag(1)
                PomodoroPage()
                    .tag(2)
                TaskGroupPage()
                    .tag(3)
                CloudStoragePage()
                    .tag(4)
                FinishPage()
                    .tag(5)
            }
            .tabViewStyle(PageTabViewStyle(indexDisplayMode: .always))
            
            Button(action: {
                if currentPage < totalPages - 1 {
                    currentPage += 1
                } else {
                    // Handle finish action
                }
            }) {
                Text(currentPage == totalPages - 1 ? "Finish" : "Next")
                    .font(.headline)
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            .frame(maxWidth: .infinity)
            .padding()
        }
    }
}
