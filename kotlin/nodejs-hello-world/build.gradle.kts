plugins {
    kotlin("multiplatform") version "1.7.20"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasm {
        binaries.executable()
//        nodejs()
        d8()
    }
    sourceSets {
        val wasmMain by getting {}
    }
}
