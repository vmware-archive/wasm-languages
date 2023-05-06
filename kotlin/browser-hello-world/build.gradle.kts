plugins {
    kotlin("multiplatform") version "1.9.0-dev-6976"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
}

kotlin {
    wasm {
        binaries.executable()
        browser()
        applyBinaryen()
    }
}
