#!/bin/sh

set -ex

dotnet publish -c Release -o release
cd release/wwwroot/
python3 -m http.server