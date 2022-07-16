import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val age = scanner.nextInt()
    val range = 18..59

    println(age in range)

}