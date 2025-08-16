package abs

fun coins() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val x = readln().toInt()

    var count = 0

    for (i in 0..a) {
        for (j in 0..b) {
            for (k in 0..c) {
                val total = 500 * i + 100 * j + 50 * k
                if (total == x) {
                    count++
                }
            }
        }
    }

    println(count)
}

fun coins2() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val x = readln().toInt()

    val count =
        (0..a).sumOf { i ->
            (0..b).sumOf { j ->
                (0..c).count { k ->
                    500 * i + 100 * j + 50 * k == x
                }
            }
        }

    println(count)
}

/*

A 500円玉 0~50枚
B 100円玉 0~50枚
C  50円玉 0~50枚

X = 500A + 100B + 50C
X = 50の倍数
X = 50~20000


カウント用の変数
    500円 1~50
        100円 1~50
            50円 1~50
                X = 500A + 100B + 50C
                X が 50 の倍数だったらカウントアップする

 */
