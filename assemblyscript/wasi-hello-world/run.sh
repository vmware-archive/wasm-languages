#!/bin/sh

set -ex

npm install
npm run asbuild:release
wasmtime build/release.wasm