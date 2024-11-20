import SwiftUI
import Shared

//
//  ThemePage.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/18/24.
//  Copyright © 2024 orgName. All rights reserved.
//
struct ThemePage: View {
    private let component: OnBoardingComponent
    @StateValue private var model: OnBoardingComponentModel
    
    init(component: OnBoardingComponent) {
        self.component = component
        self._model = StateValue(component.model)
    }
    
    var body: some View {
        ScrollView {
            CardView {
                VStack(alignment: .leading, spacing: 8) {
                    Text(Res.strings().change_theme.desc().localized())
                        .font(.largeTitle)
                    
                    Text(Res.strings().theme_text.desc().localized())
                        .font(.body)
                    
                    Button(action: {
                            //                    Task {
                            //                        do {
                            //                            try await component.changeThemeMode(themeMode: .light)
                            //                        } catch {
                            //                            print("Failed to change theme mode to light: \(error)")
                            //                        }
                            //                    }
                        }) {
                            Text(Res.strings().light_theme.desc().localized())
                                .frame(maxWidth: .infinity)
                                .padding()
                                .foregroundColor(.white)
                                .background(model.currentThemeMode == .light ? Color.blue : Color.gray)
                                .cornerRadius(8)
                        }
                        
                        Button(action: {
                            //                    Task {
                            //                        do {
                            //                            try await component.changeThemeMode(themeMode: .dark)
                            //                        } catch {
                            //                            print("Failed to change theme mode to dark: \(error)")
                            //                        }
                            //                    }
                        }) {
                            Text(Res.strings().dark_theme.desc().localized())
                                .frame(maxWidth: .infinity)
                                .padding()
                                .foregroundColor(.white)
                                .background(model.currentThemeMode == .dark ? Color.blue : Color.gray)
                                .cornerRadius(8)
                        }
                        
                        Button(action: {
                            //                    Task {
                            //                        do {
                            //                            try await component.changeThemeMode(themeMode: .system)
                            //                        } catch {
                            //                            print("Failed to change theme mode to system: \(error)")
                            //                        }
                            //                    }
                        }) {
                            Text(Res.strings().system_theme.desc().localized())
                                .frame(maxWidth: .infinity)
                                .padding()
                                .foregroundColor(.white)
                                .background(model.currentThemeMode == .system ? Color.blue : Color.gray)
                                .cornerRadius(8)
                        }
                }
            }
        }
    }
}
