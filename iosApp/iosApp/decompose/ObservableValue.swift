//
//  ObservableValue.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared

public class ObservableValue<T : AnyObject> : ObservableObject {
    @Published
    var value: T

    private var cancellation: Cancellation?
    
    init(_ value: Value<T>) {
        self.value = value.value
        self.cancellation = value.subscribe { [weak self] value in self?.value = value }
    }

    deinit {
        cancellation?.cancel()
    }
}
