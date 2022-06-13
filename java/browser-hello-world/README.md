# Java Implementation of WASM using J2CL

This sample demonstrates how to use [j2cl](https://github.com/google/j2cl) to implement a WASM function in Java and call it from the browser on port 8000.

To launch the browser (you need Chrome unstable):

```
google-chrome-unstable --js-flags="--experimental-wasm-typed-funcref  --experimental-wasm-gc --experimental-wasm-eh"
```

Then open http://localhost:8000/jsapp_dev.html.
