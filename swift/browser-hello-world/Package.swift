// swift-tools-version:5.6
import PackageDescription
let package = Package(
    name: "HelloWorldApp",
    platforms: [.macOS(.v11), .iOS(.v13)],
    products: [
        .executable(name: "HelloWorldApp", targets: ["HelloWorldApp"])
    ],
    dependencies: [
        .package(name: "Tokamak", url: "https://github.com/TokamakUI/Tokamak", from: "0.10.0")
    ],
    targets: [
        .executableTarget(
            name: "HelloWorldApp",
            dependencies: [
                .product(name: "TokamakShim", package: "Tokamak")
            ]),
        .testTarget(
            name: "HelloWorldAppTests",
            dependencies: ["HelloWorldApp"]),
    ]
)