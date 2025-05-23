package day02

fun main(){

    var a: String = "abc" // 가변, 선언및 초기화
    println(a)
    val b: Int = 1      // 불변, 선언및 초기화
    val c = 3           // 불변, 컴파일러가 타입을 추론한다.

    var e: Int
//    print(e)            // 에러, 사용전 반드시 초기화 되어야 한다.


    // 아래와 같이는 사용가능, 변수를 읽기전 초기화되어야 한다.
    val d: Int  // 1

    if (someCondition()) {
        d = 1   // 2
    } else {
        d = 2   // 2
    }

    //d = 4   //불변  val이므로 재할당 불가.

    println(d) // 3
}

fun someCondition(): Boolean {
    TODO("Not yet implemented")
}
