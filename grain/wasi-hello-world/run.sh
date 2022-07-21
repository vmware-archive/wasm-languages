#!/bin/sh

set -ex
mkdir -p build
grain compile --release --elide-type-info -o build/hello.wasm hello.gr
wasmtime build/hello.wasm