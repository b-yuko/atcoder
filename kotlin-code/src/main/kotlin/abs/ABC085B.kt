package abs

fun kagamiMochi(){
    val list = mutableListOf<Int>()

    val n = readln().toInt()

    repeat(n){
        list.add(readln().toInt())
    }

    val uniqueList = list.distinct()

    println(uniqueList.size)
}

// リファクタリング
fun countUniqueMochi(){
    val n = readln().toInt()
    val sizes = List(n) { readln().toInt() }

    println(sizes.toSet().size)
}


/*

1行目の入力は無視できる
2行目以降の入力はリストで持つ
リストから重複を排除する
リストのサイズを取得する

 */

