#!/bin/sh

set -ex

npm install
npm run asbuild:release
python3 -m http.server
