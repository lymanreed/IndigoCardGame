fun main() {
    val ints = List(readln().toInt()) { readln() }
    val (p, m) = readln().split(" ")
    val test = mutableListOf(false, false)
    var response = "NO"
    for (i in ints) {
        if (i == p) test[0] = true
        if (i == m) test[1] = true
        if (listOf(true, true) == test) {
            response = "YES"
            break
        }
    }
    println(response)
}
