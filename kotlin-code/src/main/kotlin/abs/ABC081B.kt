package abs

fun shiftOnly() {
    readln().toInt()
    var numbers = readln().split(" ").map { it.toInt() }

    var count = 0
    while (numbers.all { it % 2 == 0 }) {
        count += 1
        numbers = numbers.map { it / 2 }
    }

    println(count)
}
