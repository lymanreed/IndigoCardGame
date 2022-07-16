import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val checkMe = scanner.nextInt()
    val low = scanner.nextInt()
    val high = scanner.nextInt()

    val range = low..high

    println(checkMe in range)

}