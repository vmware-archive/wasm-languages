import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin

plugins {
//    kotlin("multiplatform") version "1.7.20" // Compatible with Node 18.12.0 (current LTS)
    kotlin("multiplatform") version "1.8.0-Beta-198" // Compatible with Node 19.0.0
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}

kotlin {
    wasm {
        binaries.executable()
        nodejs()
        d8()
    }
    sourceSets {
        val wasmMain by getting {}
    }
}

rootProject.plugins.withType(NodeJsRootPlugin::class.java) {
//    rootProject.the<NodeJsRootExtension>().nodeVersion = "18.12.0"
    rootProject.the<NodeJsRootExtension>().nodeVersion = "19.0.0"
}
