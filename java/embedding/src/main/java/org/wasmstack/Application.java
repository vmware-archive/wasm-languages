package org.wasmstack;

import java.nio.ByteBuffer;

import io.github.kawamuray.wasmtime.Func;
import io.github.kawamuray.wasmtime.Linker;
import io.github.kawamuray.wasmtime.Memory;
import io.github.kawamuray.wasmtime.Module;
import io.github.kawamuray.wasmtime.Store;
import io.github.kawamuray.wasmtime.wasi.WasiCtx;
import io.github.kawamuray.wasmtime.wasi.WasiCtxBuilder;
import io.github.kawamuray.wasmtime.Val;

class Application {

    public static void main(String[] args) {
        WasiCtx wasi = new WasiCtxBuilder().inheritStdout().inheritStderr().build();
        Store<Void> store = Store.withoutData(wasi);
        Module module = Module.fromFile(store.engine(), "./sha512/target/wasm32-wasi/release/sha512.wasm");
        Linker linker = new Linker(store.engine());
        WasiCtx.addToLinker(linker);
        linker.module(store, "", module);
        Memory memory = linker.get(store, "", "memory").get().memory();

        String input = "hello world";
        System.out.println("Input:  " + input);
        
        byte[] bytes = input.getBytes();
        ByteBuffer buffer = memory.buffer(store);
        buffer.put(bytes);
        
        Func hashFunc = linker.get(store, "", "hash").get().func();
        Val[] values = hashFunc.call(store, Val.fromI32(0), Val.fromI32(bytes.length));
        
        buffer.position(values[0].i32());
        byte[] rawOutput = new byte[values[1].i32()];
        buffer.get(rawOutput);
        String output = new String(rawOutput);

        System.out.println("Output: " + output);
    }
}