package abs

//fun someSums(){
//    val input = readln().split(" ").map { it.toInt() }
//    val n = input[0]
//    val a = input[1]
//    val b = input[2]
//
//    val numbers = mutableListOf<Int>()
//    for (i in 1..n) {
//        val num = sumOfDigits(i)
//        if(a <= num && num <= b){
//            numbers.add(i)
//        }
//    }
//    val result = numbers.sum()
//
//    println(result)
//}

fun sumOfDigits(number: Int): Int {
    return number.toString()
        .map { it.toString().toInt() }
        .sum()
}

fun someSums(){
    val input = readln().split(" ").map { it.toInt() }
    val n = input[0]
    val a = input[1]
    val b = input[2]

    val numbers = mutableListOf<Int>()
    for (i in 1..n) {
        val num = sumOfDigits(i)
        if(num in a..b){
            numbers.add(i)
        }
    }
    val result = numbers.sum()

    println(result)
}
