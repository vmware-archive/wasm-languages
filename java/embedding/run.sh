#!/bin/sh

set -ex

cd sha512
cargo rustc --release --target wasm32-wasi -- -C target-feature=+multivalue
cd ..
mvn package
java -jar target/embedding.jar
