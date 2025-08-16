package abs

fun placingMarbles() {
    val s = readln()
    val countOnes = s.count { it == '1' }

    println(countOnes)
}
