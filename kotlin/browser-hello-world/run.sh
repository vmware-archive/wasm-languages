#!/bin/sh

set -ex

./gradlew wasmBrowserDistribution
cp build/js/packages/wasm-example-wasm/kotlin/wasm-example-wasm.wasm build/distributions/wasm-example-wasm.wasm
cp build/js/packages/wasm-example-wasm/kotlin/wasm-example-wasm.wat  build/distributions/wasm-example-wasm.wat
python3 -m http.server -d build/distributions