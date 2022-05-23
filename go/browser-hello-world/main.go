package main

import (
	"syscall/js"
)

func main() {
	var Document = js.Global().Get("document")
	var Body = Document.Get("body")
	var Element = Document.Call("createElement", "p")
	Element.Set("textContent", "Hello World!")
	Body.Call("appendChild", Element)
}
