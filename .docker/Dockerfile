FROM gitpod/workspace-full:latest

USER root

RUN npm install jsvu wasm-opt wasm-pack -g \
 && wget https://github.com/tinygo-org/tinygo/releases/download/v0.23.0/tinygo_0.23.0_amd64.deb \
 && dpkg -i tinygo_0.23.0_amd64.deb \
 && rm tinygo_0.23.0_amd64.deb
 
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && curl -fsSL https://storage.googleapis.com/www.bazel.build/bazel-release.pub.gpg | gpg --dearmor > bazel-archive-keyring.gpg \
    && mv bazel-archive-keyring.gpg /usr/share/keyrings/ \
    && echo "deb [arch=amd64 signed-by=/usr/share/keyrings/bazel-archive-keyring.gpg] https://storage.googleapis.com/bazel-apt stable jdk1.8" > /etc/apt/sources.list.d/bazel.list

RUN apt-get update && apt-get install bazel-5.1.0 && ln -s /usr/bin/bazel-5.1.0 /usr/bin/bazel

RUN curl -fsSL https://github.com/WebAssembly/binaryen/releases/download/version_108/binaryen-version_108-x86_64-linux.tar.gz | tar -xzf - \
    && (cd binaryen-version_108; cp -rf * /usr) && rm -rf binaryen*

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
 && sudo mv .build/release/carton /usr/bin \
 && rm -rf ../carton

RUN curl -fsSL https://dot.net/v1/dotnet-install.sh | bash /dev/stdin --version 6.0.101 --install-dir dotnet \
 && cd dotnet \
 && ./dotnet workload install wasm-tools

RUN curl -LO https://github.com/grain-lang/grain/releases/download/grain-v0.5.2/grain-linux-x64 \
 && sudo mv grain-linux-x64 /usr/local/bin/grain \ 
 && sudo chmod +x /usr/local/bin/grain

ENV PATH="/home/gitpod/emsdk:/home/gitpod/emsdk/upstream/emscripten:${PATH}"
ENV PATH="/home/gitpod/dotnet:${PATH}"
