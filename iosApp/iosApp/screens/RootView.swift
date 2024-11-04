import SwiftUI
import Shared

//
//  RootView.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//
struct RootView: View {

    private let root: RootComponent

    init(root: RootComponent) {
        self.root = root
    }

    var body: some View {
        StackView(
            stackValue: StateValue(root.childStack),
            getTitle: { _ in "Skillingo" },
            onBack: { toIndex in },
            childContent: { child in
                switch child {
                case let child as Home : HomeView()
                case let child as OnBoarding : OnBoardingView(component: child.component)
                default: ContentView()
                }
            }
        )
    }
}


private typealias Home = RootComponentChild.Home
private typealias OnBoarding = RootComponentChild.Onboarding

