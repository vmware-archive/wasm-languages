#!/bin/sh

set -ex
tinygo build -no-debug -o build/hello-world.wasm -target wasm ./main.go
cp $(tinygo env TINYGOROOT)/targets/wasm_exec.js build/
cp index.html build/
python3 -m http.server --directory build/