fun main() {
    val listOne = List(readLine()!!.toInt()) { readLine()!! }
    val listTwo = mutableListOf<String>()
    listTwo.add(listOne.last())
    for (i in listOne.indices) {
        if (i == listOne.lastIndex) break
        listTwo.add(listOne[i])
    }
    print(listTwo.joinToString(" "))
}
