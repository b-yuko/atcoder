@file:Suppress("ktlint")

package template

/*
AtCoder用 数学系テンプレート
AtCoder Beginners Selection でよく使う数学関数

===========================================
最大公約数・最小公倍数
===========================================

// 最大公約数 (Greatest Common Divisor)
fun gcd(a: Long, b: Long): Long {
    return if (b == 0) a else gcd(b, a % b)
}

fun gcd(a: Int, b: Int): Int = gcd(a.toLong(), b.toLong()).toInt()

// 最小公倍数 (Least Common Multiple)
fun lcm(a: Long, b: Long): Long = a / gcd(a, b) * b
fun lcm(a: Int, b: Int): Int = lcm(a.toLong(), b.toLong()).toInt()

===========================================
素数関連
===========================================

// 素数判定
fun isPrime(n: Long): Boolean {
    if (n < 2) return false
    if (n == 2L) return true
    if (n % 2 == 0L) return false

    var i = 3L
    while (i * i <= n) {
        if (n % i == 0L) return false
        i += 2
    }
    return true
}

fun isPrime(n: Int): Boolean = isPrime(n.toLong())

// n以下の素数一覧（エラトステネスの篩）
fun sieve(n: Int): List<Int> {
    val isPrime = BooleanArray(n + 1) { true }
    isPrime[0] = false
    if (n >= 1) isPrime[1] = false

    for (i in 2..n) {
        if (isPrime[i]) {
            var j = i * i
            while (j <= n) {
                isPrime[j] = false
                j += i
            }
        }
    }

    return (2..n).filter { isPrime[it] }
}

===========================================
約数関連
===========================================

// 約数の個数を数える
fun countDivisors(n: Long): Int {
    var count = 0
    var i = 1L
    while (i * i <= n) {
        if (n % i == 0L) {
            count++
            if (i * i != n) count++
        }
        i++
    }
    return count
}

fun countDivisors(n: Int): Int = countDivisors(n.toLong())

// 約数の一覧を取得
fun getDivisors(n: Long): List<Long> {
    val divisors = mutableListOf<Long>()
    var i = 1L
    while (i * i <= n) {
        if (n % i == 0L) {
            divisors.add(i)
            if (i * i != n) divisors.add(n / i)
        }
        i++
    }
    return divisors.sorted()
}

fun getDivisors(n: Int): List<Int> = getDivisors(n.toLong()).map { it.toInt() }

===========================================
便利な計算関数
===========================================

// x を n 回割ったときの商（ABC081B - Shift Only用）
fun divideCount(x: Long, n: Long): Int {
    var count = 0
    var current = x
    while (current % n == 0L) {
        current /= n
        count++
    }
    return count
}

fun divideCount(x: Int, n: Int): Int = divideCount(x.toLong(), n.toLong())

// べき乗（繰り返し二乗法）
fun pow(base: Long, exp: Long, mod: Long = Long.MAX_VALUE): Long {
    var result = 1L
    var b = base % mod
    var e = exp

    while (e > 0) {
        if (e % 2 == 1L) {
            result = (result * b) % mod
        }
        b = (b * b) % mod
        e /= 2
    }
    return result
}

fun pow(base: Int, exp: Int): Long = pow(base.toLong(), exp.toLong())

===========================================
組み合わせ・順列（小さいnの場合）
===========================================

// 階乗
fun factorial(n: Int): Long {
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return result
}

// 順列 nPr
fun permutation(n: Int, r: Int): Long {
    if (r > n) return 0
    var result = 1L
    for (i in (n - r + 1)..n) {
        result *= i
    }
    return result
}

// 組み合わせ nCr
fun combination(n: Int, r: Int): Long {
    if (r > n || r < 0) return 0
    if (r == 0 || r == n) return 1

    val actualR = minOf(r, n - r)  // 計算量を減らすため

    var result = 1L
    for (i in 0 until actualR) {
        result = result * (n - i) / (i + 1)
    }
    return result
}

===========================================
使用例
===========================================

// ABC087B - Coins の例
fun solveCoins() {
    val a = readln().toInt()  // 500円硬貨の枚数
    val b = readln().toInt()  // 100円硬貨の枚数
    val c = readln().toInt()  // 50円硬貨の枚数
    val x = readln().toInt()  // 作りたい金額

    var count = 0
    for (i in 0..a) {
        for (j in 0..b) {
            for (k in 0..c) {
                if (500 * i + 100 * j + 50 * k == x) {
                    count++
                }
            }
        }
    }
    println(count)
}

*/
