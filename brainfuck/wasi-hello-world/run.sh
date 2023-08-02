#!/bin/sh

set -ex
mkdir -p build
bfc --optimize hello.bf -o build/hello.wasm
wasmtime build/hello.wasm