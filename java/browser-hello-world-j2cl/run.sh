#!/bin/sh

set -ex

bazel run src/main/java/com/google/j2cl/samples/wasm:jsapp_dev_server
