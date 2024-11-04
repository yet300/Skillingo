//
//  RootHolder.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared
import root

class RootHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    let root: RootComponent

    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()

        root = DefaultRootComponent(
            componentContext: DefaultComponentContext(lifecycle: lifecycle)
        )

        LifecycleRegistryExtKt.create(lifecycle)
    }

    deinit {
        // Destroy the root component before it is deallocated
        LifecycleRegistryExtKt.destroy(lifecycle)
    }
}
