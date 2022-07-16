data class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value < -92 || value > 57) {
                when (name) {
                    "Dubai" -> 30
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    else -> value
                }
            } else {
                value
            }
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    // implement comparing here

    val cities = listOf(firstCity, secondCity, thirdCity)
    if (
            firstCity.degrees == secondCity.degrees ||
            firstCity.degrees == thirdCity.degrees ||
            secondCity.degrees == thirdCity.degrees
    ) {
        println("neither")
    } else {
        var coldestIndex = 0
        for (i in 1 until cities.size) {
            if (cities[i].degrees < cities[coldestIndex].degrees) {
                coldestIndex = i
            }
        }
        println(cities[coldestIndex].name)
    }
}
