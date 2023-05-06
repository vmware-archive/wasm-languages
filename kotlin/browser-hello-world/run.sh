#!/bin/sh

set -ex

./gradlew wasmBrowserDistribution
python3 -m http.server -d build/dist/wasm/productionExecutable/