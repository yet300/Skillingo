//
//  AppDelegate.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared

class AppDelegate: NSObject, UIApplicationDelegate {
    let root: RootComponent = DefaultRootComponent(
        componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle())
    )
}
