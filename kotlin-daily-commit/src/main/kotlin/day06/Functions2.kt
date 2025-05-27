package day06

fun main() {

    //infix functions
    //Kotlin에서 중간에 연산자처럼 사용할수 있는 함수

    //infix function 예시
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    //kotlin 표준 infix 함수.
    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }

}
