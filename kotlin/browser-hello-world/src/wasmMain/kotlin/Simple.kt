import kotlinx.browser.document

fun main() {
    val p = document.createElement("p")
    p.innerHTML = "Hello World!"
    document.body?.appendChild(p)
}
