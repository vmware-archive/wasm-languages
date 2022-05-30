#!/bin/sh

set -ex

carton bundle
cd Bundle
python3 -m http.server