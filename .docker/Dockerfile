FROM gitpod/workspace-full:latest

USER root

RUN npm install jsvu wasm-opt wasm-pack -g \
 && wget https://github.com/tinygo-org/tinygo/releases/download/v0.23.0/tinygo_0.23.0_amd64.deb \
 && dpkg -i tinygo_0.23.0_amd64.deb \
 && rm tinygo_0.23.0_amd64.deb
 
USER gitpod

RUN rustup target add wasm32-wasi wasm32-unknown-unknown \
 && export PATH="${HOME}/.jsvu:${PATH}" \
 && jsvu v8@9.2.212 --os=default \
 && curl https://wasmtime.dev/install.sh -sSf | bash

RUN curl -LO https://github.com/kateinoigakukun/ruby.wasm/releases/download/2022-03-28-a/ruby-head-wasm32-unknown-wasi-full.tar.gz \
 && tar xfz ruby-head-wasm32-unknown-wasi-full.tar.gz \
 && mv head-wasm32-unknown-wasi-full/usr/local/bin/ruby ruby.wasm \
 && curl -LO "https://github.com/kateinoigakukun/wasi-vfs/releases/download/v0.1.1/wasi-vfs-cli-x86_64-unknown-linux-gnu.zip" \
 && unzip wasi-vfs-cli-x86_64-unknown-linux-gnu.zip \
 && sudo mv wasi-vfs /usr/local/bin/wasi-vfs

RUN git clone --depth 1 https://github.com/emscripten-core/emsdk.git \
 && cd emsdk \
 && ./emsdk install latest \
 && ./emsdk activate latest

RUN wget https://swift.org/builds/swift-5.6.1-release/ubuntu2004/swift-5.6.1-RELEASE/swift-5.6.1-RELEASE-ubuntu20.04.tar.gz \
 && tar xfz swift-5.6.1-RELEASE-ubuntu20.04.tar.gz \
 && export PATH="/home/gitpod/swift-5.6.1-RELEASE-ubuntu20.04/usr/bin:${PATH}" \
 && git clone https://github.com/swiftwasm/carton.git \
 && cd carton \
 && swift build -c release \
 && sudo mv .build/release/carton /usr/bin

ENV PATH="/home/gitpod/emsdk:/home/gitpod/emsdk/upstream/emscripten:${PATH}"
