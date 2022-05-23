#!/bin/sh

set -ex
GOOS=js GOARCH=wasm go build -o build/hello-world.wasm main.go
cp "$(go env GOROOT)/misc/wasm/wasm_exec.js" build/
cp index.html build/
python3 -m http.server --directory build/