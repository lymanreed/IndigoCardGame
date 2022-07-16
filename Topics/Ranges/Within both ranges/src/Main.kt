import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val (a1, a2, b1, b2, test) = List(5) { scanner.nextInt() }
    println(test in a1..a2 && test in b1..b2)
}
