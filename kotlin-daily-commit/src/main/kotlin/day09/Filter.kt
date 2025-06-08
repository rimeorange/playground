package day09

fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val positives = numbers.filter { n -> n > 0 }

    val negatives = numbers.filter { it < 0 }

    println(positives)

    println(negatives)
}