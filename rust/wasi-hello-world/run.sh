#!/bin/sh

set -ex

cargo build --target wasm32-wasi --release
wasmtime target/wasm32-wasi/release/wasi-hello-world.wasm
