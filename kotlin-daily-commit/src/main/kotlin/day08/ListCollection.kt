package day08

val systemUsers: MutableList<Int> = mutableListOf(1,2,3) //변경가능.
val sudoers: List<Int> = systemUsers                //read-only

fun addSystemUser(newUser: Int) {
    systemUsers.add(newUser)
}

fun getSysSudoers(): List<Int> {
    return sudoers
}

fun main() {
    addSystemUser(4)
    println("Tot soduers: ${getSysSudoers().size}")
    getSysSudoers().forEach {
        i -> println("Some useful info on user $i")
    }

    //getSysSudoers().add(5) <- error, 변경불가
}