//  OnBoardingView.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct OnBoardingView: View {
    
    private let component: OnBoardingComponent
    
    init(component: OnBoardingComponent) {
        self.component = component
    }
    
    var body: some View {
        VStack{
            Text("OnBoarding")

            Button("Next") {
                component.onClick()
            }
        }
    }
}

