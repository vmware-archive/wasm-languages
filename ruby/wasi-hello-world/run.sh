#!/bin/sh

set -ex
mkdir -p build
wasi-vfs pack /home/gitpod/ruby.wasm --mapdir /src::./src --mapdir /usr::/home/gitpod/head-wasm32-unknown-wasi-full/usr -o build/app-runner.wasm
wasmtime build/app-runner.wasm -- src/hello_world.rb
