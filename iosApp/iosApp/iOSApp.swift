import SwiftUI
import Shared

@main
struct iOSApp: App {

    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    @StateObject private var themeManager = ThemeManager()
    
    init() {
        KoinKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            RootView(root: appDelegate.root)
                .preferredColorScheme(themeManager.currentThemeMode)
//                .environment(\.colorScheme, themeManager.isDarkMode ? .dark : .light)
        }
    }
}
