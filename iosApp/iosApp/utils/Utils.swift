import Shared
import SwiftUI

extension Image {
    init(resource: KeyPath<Res.images, ImageResource>) {
        self.init(uiImage: Res.images()[keyPath: resource].toUIImage()!)
    }
}