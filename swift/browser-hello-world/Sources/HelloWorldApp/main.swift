import TokamakDOM

struct HelloWorldApp: App {
    var body: some Scene {
        WindowGroup("Hello World App") {
            ContentView()
        }
    }
}

struct ContentView: View {
    var body: some View {
        Text("Hello, world!")
    }
}

// @main attribute is not supported in SwiftPM apps.
// See https://bugs.swift.org/browse/SR-12683 for more details.
HelloWorldApp.main()
