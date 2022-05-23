# Kotlin hello world in V8

This example leverages Kotlin/Wasm and V8 and GC, typed function references and exception handling proposals.

For now, a specific version of V8 is required to make it work. Install [JSVU](https://github.com/GoogleChromeLabs/jsvu) and then install the right V8 version: 
```
jsvu v8@9.2.212
```

You can build and run the example locally with:

```
 ./gradlew run
```

In order to generate the optimized version, you need to install [Binaryen](https://github.com/WebAssembly/binaryen) which will provide the `wasm-opt` tool. When that's done run the following command to generate the optimized version:

```
 ./gradlew runOptimized
```