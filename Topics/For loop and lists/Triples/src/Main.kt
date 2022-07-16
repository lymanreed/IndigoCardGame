fun main() {
    val list = Array(readLine()!!.toInt()) { readLine()!!.toInt() }
    var count = 0
    for (i in 0..list.size - 3) {
        if (list[i + 1] == list[i] + 1 && list[i + 2]  == list[i + 1] + 1) count++
    }
    println(count)
}
