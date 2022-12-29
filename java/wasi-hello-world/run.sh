#!/bin/sh

set -ex

mvn clean package
wasmtime target/generated/wasm/teavm-wasm/classes.wasm