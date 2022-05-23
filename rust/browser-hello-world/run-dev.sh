#!/bin/sh

set -ex

wasm-pack build --target web --dev
python3 -m http.server
