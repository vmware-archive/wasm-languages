#!/bin/sh

set -ex

mkdir -p build
emcc src/hello_world.c -O3 -o build/index.js
node build/index.js
