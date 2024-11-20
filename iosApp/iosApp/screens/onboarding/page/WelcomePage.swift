import Shared
import SwiftUI

//
//  WelcomePage.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/18/24.
//  Copyright © 2024 orgName. All rights reserved.
//
struct WelcomePage: View {
    var body: some View {
        ScrollView {
            CardView {
                VStack(alignment: .leading, spacing: 8) {
                    Text(Res.strings().welcome.desc().localized())
                        .font(.largeTitle)
                    
                    Text(Strings().get(id: Res.strings().welcome_text, args: []))
                        .font(.body)
                    
                    VStack(alignment: .leading){
                        EmojiCardView(emoji: "🔥", title: Res.strings().shock_mode_title.desc().localized(), description: Res.strings().shock_mode_description.desc().localized())
                        EmojiCardView(emoji: "🚀", title: Res.strings().endless_tasks_title.desc().localized(), description: Res.strings().endless_tasks_description.desc().localized())
                        EmojiCardView(emoji: "🍅", title: Res.strings().pomadoro_timer_title.desc().localized(), description: Res.strings().pomadoro_timer_description.desc().localized())
                        EmojiCardView(emoji: "🌏", title: Res.strings().etc.desc().localized(), description: Res.strings().etc_description.desc().localized())
                    }
                }
            }
        }
    }
}
