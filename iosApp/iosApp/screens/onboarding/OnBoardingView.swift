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
    @StateValue private var model: OnBoardingComponentModel

    @State private var currentPage: Int

    init(onboarding: OnBoardingComponent) {
        self.onboarding = onboarding
        self._model = StateValue(onboarding.model)
        self._currentPage = State(initialValue: Int(onboarding.model.value.currentPage))
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
                if currentPage < 5 {
                    currentPage += 1
                    DispatchQueue.main.async {
                        onboarding.setCurrentPage(page: Int32(currentPage))
                    }
                } else {
                    onboarding.onClick()
                }
            }) {
                Text(model.currentPage == model.totalPages - 1 ? Res.strings().start.desc().localized() : Res.strings().continues.desc().localized())
                    .font(.headline)
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            .padding(.horizontal, UIScreen.main.bounds.width > 600 ? 40 : 16)
            .frame(maxWidth: .infinity)
        }
    }
}
