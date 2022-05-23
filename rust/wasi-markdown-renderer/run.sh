#!/bin/sh

set -ex

cargo build --target wasm32-wasi --release
wasmtime --dir . target/wasm32-wasi/release/wasi-markdown-renderer.wasm example.md
