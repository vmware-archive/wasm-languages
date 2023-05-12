package org.wasmstack;

import de.mirkosertic.bytecoder.api.web.Element;
import de.mirkosertic.bytecoder.api.web.HTMLDocument;
import de.mirkosertic.bytecoder.api.web.Window;

public class Main {
	public static void main(String[] args) {
		HTMLDocument document = Window.window().document();
		Element p = document.createElement("p");
		p.innerHTML("Hello World!");
		document.body().appendChild(p);
	}
}
