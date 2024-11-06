//
//  HomeView.swift
//  iosApp
//
//  Created by Ruslan Gadzhiev on 11/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct HomeView: View {

//    private let component: HomeComponent
//
//    init(component: HomeComponent) {
//        self.component = component
//    }

    var body: some View {
        VStack{
            Text("home screen!")            
            Text(
                Res.strings().test.desc().localized()
            )
            
            Text(
                Strings().get(id: Res.strings().hello_world, args:[])
            )
        }.padding()
    }
}

#Preview {
    HomeView()
}
