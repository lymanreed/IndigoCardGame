fun main() {
    val nums = List(readLine()!!.toInt()) { readLine()!! }
    val findMe = readLine()!!
    println(if (findMe in nums) "YES" else "NO")
}
