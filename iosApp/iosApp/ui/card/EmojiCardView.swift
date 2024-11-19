import SwiftUI

//
//  EmojiCardView.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/19/24.
//  Copyright © 2024 orgName. All rights reserved.
//
struct EmojiCardView: View {
    let emoji: String
    let title: String
    let description: String
    
    var body: some View {
        HStack(spacing: 8) {
            Text(emoji)
                .font(.largeTitle)
            VStack(alignment: .leading, spacing: 4) {
                Text(title)
                    .font(.headline)
                Text(description)
                    .font(.subheadline)
            }
        }
        .padding()
        .background(RoundedRectangle(cornerRadius: 10).fill(Color(.systemBackground)).shadow(radius: 2))
    }
}
