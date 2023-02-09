import kotlinx.browser.document
import kotlinx.dom.appendText

fun main() {
    val p = document.createElement("p")
    p.innerHTML = "Hello World!"
    document.body?.appendChild(p)
}
