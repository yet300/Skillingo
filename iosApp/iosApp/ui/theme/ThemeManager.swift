import SwiftUI
import Shared

class ThemeManager: ObservableObject {
    @Published var currentThemeMode: ColorScheme?

    private let themeModeRepository = RepositoryHelper().themeModeRepository()

    init() {
        fetchThemeMode()
    }

    private func fetchThemeMode() {
//        Task {
//            do {
//                try await themeModeRepository.readThemeMode().collect { themeMode in
//                    if let themeMode = themeMode as? ThemeMode {
//                        DispatchQueue.main.async { [weak self] in
//                            self?.currentThemeMode = self?.convertToColorScheme(themeMode: themeMode)
//                        }
//                    }
//                }
//            } catch {
//                print("Failed to fetch theme mode: \(error)")
//            }
//        }
    }

    private func convertToColorScheme(themeMode: ThemeMode) -> ColorScheme {
        switch themeMode {
        case .light: return .light
        case .dark: return .dark
        case .system: return .light
        default: return .light
        }
    }
}
