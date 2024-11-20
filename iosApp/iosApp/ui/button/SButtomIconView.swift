//
//  ProviderButton.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/20/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct SButtomIconView: View {
    let title:String
    let image:KeyPath<Res.images, Shared.ImageResource>
    let isSelected: Bool
    let onSelect: () -> Void

    var body: some View {
        HStack(spacing: 8) {
            Image(resource: image)
                .resizable()
                .renderingMode(.template)
                .foregroundColor(isSelected ? .blue : .gray)
                .frame(width: 40, height: 40)


            Button(action: onSelect) {
                Text(title)
                    .foregroundColor(isSelected ? .blue : .primary)
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color(UIColor.systemBackground))
                    .cornerRadius(8)
                    .overlay(
                        RoundedRectangle(cornerRadius: 8)
                            .stroke(isSelected ? Color.blue : Color.clear, lineWidth: 2)
                    )
            }
        }
    }
}
