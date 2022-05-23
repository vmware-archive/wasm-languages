#!/usr/bin/env bash

HOST_WORK_DIR=`echo $( pwd ) | sed -e 's/^[^=]*=//g'`

set -ex

docker build -t sdeleuze/wasm-languages - < .docker/Dockerfile

docker build -t sdeleuze/wasm-languages-dev --build-arg BASE_IMAGE=sdeleuze/wasm-languages \
  --build-arg USER=$USER \
  --build-arg USER_ID=$(id -u ${USER}) \
  --build-arg USER_GID=$(id -g ${USER}) \
  - < .docker/Dockerfile.dev

 docker run -p 8000:8000 -it -v $HOST_WORK_DIR:/workspace:delegated sdeleuze/wasm-languages-dev /bin/bash
 