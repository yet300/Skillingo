import Shared
import SwiftUI

//
//  CloudStoragePage.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/18/24.
//  Copyright ©  orgName. All rights reserved.
//
struct CloudStoragePage: View {
    @State private var selectedProvider: CloudProvider = CloudProvider(name: "Offline", iconResId: \.offline )
    
    let providers = [
        CloudProvider(name: "Offline", iconResId: \.offline),
        CloudProvider(name: "GitHub", iconResId: \.github),
        CloudProvider(name: "Google Drive", iconResId: \.google_drive),
        CloudProvider(name: "Apple iCloud", iconResId: \.icloud)
    ]
    
    var body: some View {
        ScrollView {
            CardView {
                VStack(spacing: 8) {
                    Text(Res.strings().cloud_storage_title.desc().localized())
                        .font(.largeTitle)
                        .foregroundColor(Color(UIColor.label))
                    Text(Res.strings().cloud_storage_description.desc().localized())
                        .font(.body)
                        .foregroundColor(Color(UIColor.secondaryLabel))
                    
                    ForEach(providers, id: \.name) { provider in
                        SButtomIconView(
                            title: provider.name,
                            image: provider.iconResId,
                            isSelected: selectedProvider.name == provider.name,
                            onSelect: {
                                selectedProvider = provider
                            }
                        )
                    }
                    .padding(18)
                }
            }
        }
    }
}

struct CloudProvider {
    let name: String
    let iconResId: KeyPath<Res.images, Shared.ImageResource>
}
