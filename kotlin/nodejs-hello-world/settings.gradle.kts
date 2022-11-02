rootProject.name = "nodejs-hello-world"

pluginManagement {
    resolutionStrategy {
        repositories {
            mavenLocal()
            gradlePluginPortal()
            maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        }
    }
}
