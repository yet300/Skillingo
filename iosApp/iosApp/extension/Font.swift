//
//  Font.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/6/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import Shared

extension Font {
    init(resource: KeyPath<Res.fonts, FontResource>, withSize: Double = 14.0) {
        self.init(Res.fonts()[keyPath: resource].uiFont(withSize: withSize))
    }
}
