#!/bin/sh

set -ex
mkdir -p build
tinygo build -no-debug -o build/hello-world.wasm -target wasi ./main.go
wasmtime build/hello-world.wasm