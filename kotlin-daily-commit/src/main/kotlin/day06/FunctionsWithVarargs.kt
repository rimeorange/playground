package day06

fun main() {
    printAll("Hello", "Hallo", "Salut", "Hola")

    printAllWithPrefix(
    "Hello", "Hallo", "Salut", "Hola",
    prefix = "Greeting: "                                          // 4
    )

    log("Hello", "Hallo", "Salut", "Hola")
}

fun log(vararg entries: String) {
    printAll(*entries)
}

fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}