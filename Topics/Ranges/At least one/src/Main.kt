fun main() {
    val numbers = List(5) { readln().toInt() }
    print(
        numbers[4] in numbers[0]..numbers[1] || numbers[4] in numbers[2]..numbers[3]
    )
}
