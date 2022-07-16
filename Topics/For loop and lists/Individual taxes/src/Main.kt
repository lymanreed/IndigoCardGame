fun main() {
    val nCompanies = readln().toInt()
    val incomes = List(nCompanies) { readln().toInt() }
    val taxPercentages = List(nCompanies) { readln().toInt() / 100.0 }
    val taxes = List(nCompanies) { incomes[it] * taxPercentages[it] }
    var highest = 0

    for (i in 1 until nCompanies) {
        if (taxes[i] > taxes[highest]) {
            highest = i
        }
    }
    println(highest + 1)
}
