#!/bin/sh

set -ex

mvn clean package
python3 -m http.server -d target/classes/META-INF/resources