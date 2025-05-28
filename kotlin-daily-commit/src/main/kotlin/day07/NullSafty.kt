package day07

fun main() {
    var neverNull: String = "This can't be null"
    //neverNull = null  //error

    var nullable: String? = "You can keep a null here"
    nullable = null     // null 허용이므로 null 할당가능

    var inferredNonNull = "The compiler assumes non-null"
    //inferredNonNull = null    //error 타입추론. null 허용 X

    strLength(neverNull)
    //strLength(nullable)       //error

}

fun strLength(nonNull: String): Int {
    return nonNull.length
}