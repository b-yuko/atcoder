@file:Suppress("ktlint")

package template

/*
AtCoder用 Kotlinテンプレート集
コピペして使用する

===========================================
基本的な入力パターン
===========================================

// 1つの整数
val n = readln().toInt()

// 1つの長整数
val n = readln().toLong()

// スペース区切りの整数リスト
val nums = readln().split(" ").map { it.toInt() }

// スペース区切りの長整数リスト
val nums = readln().split(" ").map { it.toLong() }

// 2つの整数 (a, b)
val (a, b) = readln().split(" ").map { it.toInt() }

// 3つの整数 (a, b, c)
val (a, b, c) = readln().split(" ").map { it.toInt() }

// 文字列
val s = readln()

// 複数行の入力例
val n = readln().toInt()
val items = (1..n).map { readln().toInt() }
val items = List(n) { readln().toInt() }   // ひとつ上と同じ結果を得られる

===========================================
よく使う処理パターン
===========================================

// 配列の最大値・最小値
val maxValue = nums.maxOrNull() ?: 0
val minValue = nums.minOrNull() ?: 0

// 配列の合計
val sum = nums.sum()

// 文字列を文字の配列に
val chars = s.toCharArray()

// 文字列の各文字をチェック
s.forEach { char ->
    // 処理
}

// 条件に一致する要素をカウント
val count = nums.count { it > 0 }

// 配列から重複を取り除く
val list = listOf(3, 1, 2, 3, 2)
val set = list.toSet()   // [3, 1, 2] （順序保証なし、Set型を返す）
val result = list.distinct()   // [3, 1, 2] （順序保証あり、新しいリストを返す）

===========================================
基本テンプレート
===========================================

fun solve() {
    // ここに解法を書く
    val n = readln().toInt()

    // 処理

    println(result)
}

// 提出用（solve()の中身をコピペ）
fun main() {
    val n = readln().toInt()

    // 処理

    println(result)
}
*/
