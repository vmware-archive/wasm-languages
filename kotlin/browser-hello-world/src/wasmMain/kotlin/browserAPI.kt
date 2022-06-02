external interface Document {
    var body: Element
    fun querySelector(query: String): Element
    fun createElement(localName: String): Element
}

public external abstract class Node {
    fun appendChild(node: Node): Node
}

public external abstract class Element : Node {
    open var innerHTML: String
}

external val document: Document
