package abs

fun product() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val c = a * b
    if (c % 2 == 0) {
        println("Even")
    } else {
        println("Odd")
    }
}
