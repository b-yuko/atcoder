package abs

fun practiceA() {
    val a = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }
    val c = readln()

    println("${a + b.sum()} $c")
}
