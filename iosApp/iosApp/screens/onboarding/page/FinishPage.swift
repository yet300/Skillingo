import SwiftUI
import Shared
//
//  FinishPage.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/18/24.
//  Copyright © 2024 orgName. All rights reserved.
//

struct FinishPage: View {
    var body: some View {
        ScrollView {
            CardView {
                VStack(spacing: 16) {
                    Text(Res.strings().finish_title.desc().localized())
                        .font(.largeTitle)
                    Text(Res.strings().finish_description.desc().localized())
                        .font(.body)
                }
            }
        }
    }
}
