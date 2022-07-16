fun main() {
    val list = List(readLine()!!.toInt()) { readLine()!! }
    val shift = readLine()!!.toInt() % list.size
    val newList = mutableListOf<String>()
    newList.addAll(list.takeLast(shift))
    newList.addAll(list.take(list.size - shift))
    println(newList.joinToString(" "))
}
