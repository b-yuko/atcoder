package abs

import utils.Debug

fun practiceA() {
    val a = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }
    val c = readln()

    Debug.println("a", a)
    Debug.println("b", b)
    Debug.println("c", c)

    println("${a + b.sum()} $c")
}
