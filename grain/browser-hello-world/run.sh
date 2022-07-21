#!/bin/sh

set -ex
npm install
grain compile --release --elide-type-info -o hello.wasm hello.gr
python3 -m http.server