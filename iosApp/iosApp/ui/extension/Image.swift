import SwiftUI
import Shared
import Foundation
//
//  Image.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/20/24.
//  Copyright © 2024 orgName. All rights reserved.
//
extension Image {
    init(resource: KeyPath<Res.images, Shared.ImageResource>) {
        self.init(uiImage: Res.images()[keyPath: resource].toUIImage()!)
    }
}
