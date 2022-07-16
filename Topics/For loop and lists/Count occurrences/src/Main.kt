fun main() {
    val nums = List(readLine()!!.toInt()) { readLine()!! }
    val counting = readLine()!!
    var total = 0
    for (num in nums) {
        if (num == counting) total += 1
    }
    print(total)
}