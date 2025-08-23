package abs

fun cardGameForTwo(){
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val list = a.toMutableList()

    var alice = 0
    var bob = 0

    for(i in 1 .. n){
        val maxValue = list.maxOrNull() ?: 0
        if(i % 2 == 0){
            bob += maxValue
        } else {
            alice += maxValue
        }
        list.remove(maxValue)
    }

    println(alice - bob)
}


// リファクタリング
fun cardGameForTwo2(){
    // カードの枚数(N)は今回は使わない
    readln()
    val cards = readln().split(" ").map { it.toInt() }

    // 降順に並べてから交互にカードを取る
    val sortedCards = cards.sortedDescending()

    var alice = 0
    var bob = 0

    for((index, card) in sortedCards.withIndex()){
        if(index % 2 == 0){
            alice += card
        } else {
            bob += card
        }
    }

    println(alice - bob)
}


// 高階関数を使ったリファクタリング
fun cardGameForTwo3(){
    readln()
    val cards = readln().split(" ").map { it.toInt() }

    // 降順に並べてから交互にカードを取る
    val sortedCards = cards.sortedDescending()

    val alice = sortedCards.filterIndexed { index, _ -> index % 2 == 0 }.sum()
    val bob = sortedCards.filterIndexed { index, _ -> index % 2 == 1 }.sum()

    println(alice - bob)
}





/*

N: カードの枚数
a: 得点
i: カードが何枚目か
Alice も Bob も自分の得点が最大化するようにカードを取る -> 配列の中から最大値を取得する
val maxValue = nums.maxOrNull() ?: 0


var alice = 0
var bob = o

aのリストの長さだけループする
    aのリストの奇数番目だったら
        リストから最大値を取り出し Alice に加算する
    aのリストが偶数番目だったら
        リストから最大値を取り出し Bob に加算する

 */