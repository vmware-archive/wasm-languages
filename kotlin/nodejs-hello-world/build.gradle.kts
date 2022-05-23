plugins {
    kotlin("multiplatform") version "1.7.0-Beta"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasm {
        binaries.executable()
        nodejs()
    }
    sourceSets {
        val wasmMain by getting {}
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().configureEach {
    kotlinOptions.freeCompilerArgs += listOf(
        "-Xwasm-launcher=d8",
        "-Xwasm-debug-info=false"  // Needed for binaryen
    )
}
val v8: String? by project
val v8path = v8 ?: (System.getProperty("user.home") + "/.jsvu/v8-9.2.212")

val wasmOpt: String? by project
val wasmOptPath = wasmOpt ?: "wasm-opt"

val v8flags = arrayOf(
    "--experimental-wasm-typed-funcref",
    "--experimental-wasm-gc",
    "--experimental-wasm-eh",
    "--wasm-opt",
)

val run by tasks.registering(Exec::class) {
    dependsOn(":runOptimizations")
    executable(v8path)
    setWorkingDir("$buildDir/js/packages/${project.name}-wasm-opt/kotlin/")
    args(
        *v8flags,
        "--module",
        "./${project.name}-wasm.js"
    )
}

val wasmCopyWasmForOptimizations by tasks.registering(Copy::class) {
    dependsOn(":compileProductionExecutableKotlinWasm")
    dependsOn(":wasmProductionExecutableCompileSync")
    from("$buildDir/js/packages/${project.name}-wasm/")
    into("$buildDir/js/packages/${project.name}-wasm-opt/")
}

val runOptimizations by tasks.registering(Exec::class) {
    dependsOn(wasmCopyWasmForOptimizations)
    executable(wasmOptPath)
    setWorkingDir("$buildDir/js/packages/${project.name}-wasm-opt/kotlin/")
    args(
        "--enable-nontrapping-float-to-int",
        "--enable-typed-function-references",
        "--enable-gc",
        "--enable-reference-types",
        "--enable-exception-handling",
        "../../${project.name}-wasm/kotlin/${project.name}-wasm.wasm", "-o", "./${project.name}-wasm.wasm",
        "-O3",
        "--inline-functions-with-loops",
        "--traps-never-happen",
        "--fast-math",
    )
}