fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!
    println(
        if (index !in word.indices) {
            "There isn't such an element in the given string, please fix the index!"
        } else {
            word[index]
        }
    )
}
