# Rust hello world in a browser

This example leverages [wasm-bindgen](https://rustwasm.github.io/docs/wasm-bindgen/examples/without-a-bundler.html) to display a simple hello world in the HTML page.

Debugging seems currently broken (breakpoints in Rust code not taken in account), but you can at least try watching Rust files in your browser:
 - Open Chrome.
 - Install https://goo.gle/wasm-debugging-extension.
 - In DevTools, go to settings (click the gear) -> Experiments -> Check "WebAssembly Debugging: Enable DWARF support".
 - Run `run-dev.sh`.
 - Go to http://localhost:8000/ with DevTools open, in "Sources" you should see your Rust files.