import SwiftUI
import Shared

@main
struct iOSApp: App {

    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    init() {
        KoinKt.doInitKoin()
    }
    

    var body: some Scene {
        WindowGroup {
            RootView(root: appDelegate.root)
        }
    }
}
