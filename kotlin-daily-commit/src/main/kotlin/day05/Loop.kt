package day05



fun main() {

    // for문
    var cakes = listOf("carrot", "cheese", "chocolate")

    for(cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }

    var cakesEaten = 0
    var cakesBaked = 0

    // while, do~while
    while (cakesEaten < 5) {
        eatACake()
        cakesEaten++
    }

    do {
        bakeAcake()
        cakesBaked++
    } while (cakesBaked < cakesEaten)
    //while은 조건을 만족하면 구문 실행, do~while은 구문 실행후 조건 체크

    // Iterators
    val zoo = Zoo(listOf(Animal("zebra"), Animal("carrot"), Animal("lion")))

    for (animal in zoo) {
        println("Watch out it's a ${animal.name}")
    }
}

fun eatACake() = println("Eat a Cake")

fun bakeAcake() = println("Bake a cake")

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}