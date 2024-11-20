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
        HStack(alignment: .top, spacing: 12) {
            Text(emoji)
                .font(.largeTitle)
                .frame(width: 48, height: 48)
                .alignmentGuide(.top) { d in d[.top] }
            
            VStack(alignment: .leading, spacing: 6) {
                Text(title)
                    .font(.headline)
                    .foregroundColor(.primary)
                Text(description)
                    .font(.subheadline)
                    .foregroundColor(.secondary)
                    .lineLimit(nil)
            }
        }
        .padding(12)
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(RoundedRectangle(cornerRadius: 12).fill(Color(.systemBackground)))
        .shadow(color: Color.black.opacity(0.1), radius: 4, x: 0, y: 2)
    }
}
