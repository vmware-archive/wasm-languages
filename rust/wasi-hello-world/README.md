# Rust hello world with WASI

This example displays a simple hello world in the console with [WASI](https://wasi.dev/).

You can build the example locally with:

```
cargo build --target wasm32-wasi --release
```

Then use [Wasmtime](https://wasmtime.dev/) to run it:

```
wasmtime target/wasm32-wasi/release/wasi-hello-world.wasm
```
